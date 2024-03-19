package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class CaballeroModelo {

	public static ArrayList<Caballero> getCaballeros(ArrayList<Caballero> caballeros) {
		String sql = "SELECT * FROM caballeros";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Caballero caballero = new Caballero();
				caballero.setNombre(rst.getString("NOMBRE"));
				caballero.setApellido(rst.getString("APELLIDO"));
				caballero.setExperiencia(rst.getInt("EXPERIENCIA"));
				caballero.setFuerza(rst.getInt("FUERZA"));
				caballero.setId_arma(rst.getInt("ID_ARMA"));
				caballero.setId_caballero(rst.getInt("ID_CABALLERO"));
				caballero.setId_caballo(rst.getInt("ID_CABALLO"));
				caballero.setId_escudo(rst.getInt("ID_ESCUDO"));
				caballeros.add(caballero);
			}
			return caballeros;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static Boolean crearCaballero(Caballero caballero) {
		String sql = "INSERT INTO caballeros(NOMBRE, APELLIDO, FUERZA, EXPERIENCIA, ID_ESCUDO, ID_CABALLO, ID_ARMA) VALUES (?,?,?,?,?,?,?)";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, caballero.getNombre());
			prst.setString(2, caballero.getApellido());
			prst.setInt(3, caballero.getFuerza());
			prst.setInt(4, caballero.getExperiencia());
			prst.setInt(5, caballero.getId_escudo());
			prst.setInt(6, caballero.getId_caballo());
			prst.setInt(7, caballero.getId_arma());
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static boolean eliminarCaballero(int id_caballero) {
		String sql = "DELETE FROM caballeros WHERE caballeros.ID_CABALLERO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_caballero);
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Caballero getCaballeroByID(int id_caballero, Caballero caballero) {
		String sql = "SELECT * FROM caballeros WHERE caballeros.ID_CABALLERO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_caballero);
			ResultSet rst = prst.executeQuery();
			if(rst.next()) {
				caballero.setNombre(rst.getString("NOMBRE"));
				caballero.setApellido(rst.getString("APELLIDO"));
				caballero.setExperiencia(rst.getInt("EXPERIENCIA"));
				caballero.setFuerza(rst.getInt("FUERZA"));
				caballero.setId_arma(rst.getInt("ID_ARMA"));
				caballero.setId_caballero(rst.getInt("ID_CABALLERO"));
				caballero.setId_caballo(rst.getInt("ID_CABALLO"));
				caballero.setId_escudo(rst.getInt("ID_ESCUDO"));
				return caballero;
			}else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static boolean modificarCaballero(Caballero caballero) {
		String sql = "UPDATE caballeros SET NOMBRE = ?, APELLIDO=?, FUERZA=?, EXPERIENCIA=?, ID_ESCUDO = ?, ID_CABALLO =?, ID_ARMA=? WHERE caballeros.ID_CABALLERO=?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, caballero.getNombre());
			prst.setString(2, caballero.getApellido());
			prst.setInt(3, caballero.getFuerza());
			prst.setInt(4, caballero.getExperiencia());
			prst.setInt(5, caballero.getId_escudo());
			prst.setInt(6, caballero.getId_caballo());
			prst.setInt(7, caballero.getId_arma());
			prst.setInt(8, caballero.getId_caballero());
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static boolean subirBatalla(Caballero caballeroPJ1, Caballero caballeroPJ2, Caballero ganador, LocalDate fecha) {
		String sql = "INSERT INTO historial_batallas(ID_PJ1,ID_PJ2,GANADOR,FECHA_BATALLA) VALUES(?,?,?,?)";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, caballeroPJ1.getId_caballero());
			prst.setInt(2, caballeroPJ2.getId_caballero());
			prst.setInt(3, ganador.getId_caballero());
			prst.setDate(4, Date.valueOf(fecha));
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return false;
	}
}
