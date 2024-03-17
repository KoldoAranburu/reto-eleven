package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
