package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EscudoModelo extends Conector{

	public static ArrayList<Escudo> getEscudos(ArrayList<Escudo> escudos) {
		String sql = "SELECT * FROM escudos";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Escudo escudo = new Escudo();
				escudo.setId_escudo(rst.getInt("ID_ESCUDO"));
				escudo.setNivel_defensa(rst.getInt("NIVEL_DEFENSA"));
				escudo.setNombre(rst.getString("NOMBRE"));
				escudos.add(escudo);
			}
			
			conector.deconectar();
			return escudos;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static boolean crearEscudo(Escudo escudo) {
		String sql = "INSERT INTO escudos(NOMBRE,NIVEL_DEFENSA) VALUE(?,?)";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, escudo.getNombre());
			prst.setInt(2, escudo.getNivel_defensa());
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Escudo getEscudoByID(int id_escudo, Escudo escudo) {
		String sql = "SELECT * FROM escudos WHERE escudos.ID_ESCUDO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_escudo);
			ResultSet rst = prst.executeQuery();
			if (rst.next()) {
				escudo.setId_escudo(rst.getInt("ID_ESCUDO"));
				escudo.setNivel_defensa(rst.getInt("NIVEL_DEFENSA"));
				escudo.setNombre(rst.getString("NOMBRE"));
				
				conector.deconectar();
				return escudo;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static boolean actualizarEscudo(Escudo escudo) {
		String sql = "UPDATE escudos SET escudos.NOMBRE = ?, escudos.NIVEL_DEFENSA=? WHERE escudos.ID_ESCUDO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, escudo.getNombre());
			prst.setInt(2, escudo.getNivel_defensa());
			prst.setInt(3, escudo.getId_escudo());
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static boolean eliminarEscudoByID(int id_escudo) {
		String sql = "DELETE FROM escudos WHERE escudos.ID_ESCUDO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_escudo);
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static ArrayList<Escudo> getEscudosNoAsignados(ArrayList<Escudo> escudos) {
		String sql = "SELECT * FROM escudos WHERE escudos.ID_ESCUDO NOT IN (SELECT a.ID_ESCUDO FROM escudos A JOIN caballeros B ON A.ID_ESCUDO=b.ID_ESCUDO);";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Escudo escudo = new Escudo();
				escudo.setId_escudo(rst.getInt("ID_ESCUDO"));
				escudo.setNivel_defensa(rst.getInt("NIVEL_DEFENSA"));
				escudo.setNombre(rst.getString("NOMBRE"));
				escudos.add(escudo);
			}
			
			conector.deconectar();
			return escudos;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static ArrayList<Caballero> getCaballerosNoAsignado() {
		
		String sql = "SELECT * FROM caballeros WHERE caballeros.ID_CABALLERO NOT IN (SELECT a.ID_CABALLERO FROM escuderos A JOIN caballeros B ON A.ID_CABALLERO=b.ID_CABALLERO)";
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
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
			
			conector.deconectar();
			return caballeros;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
