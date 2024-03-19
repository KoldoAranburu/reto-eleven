package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controlador.GestorEscuderos;

public class EscuderoModelo {

	public static ArrayList<Escudero> getEscuderos() {
		ArrayList<Escudero>  escuderos = new ArrayList<Escudero>();
		String sql = "SELECT * FROM escuderos";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Escudero escudero = new Escudero();
				escudero.setId_escudero(rst.getInt("ID_ESCUDERO"));
				escudero.setId_caballero(rst.getInt("ID_CABALLERO"));
				escudero.setApellido(rst.getString("APELLIDO"));
				escudero.setNombre(rst.getString("NOMBRE"));
				escudero.setExperiencia(rst.getInt("EXPERIENCIA"));
				escuderos.add(escudero);
			}
			conector.deconectar();
			return escuderos;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static boolean eliminarEscuderoByID(int id_escudero) {
		desasignarCaballeroAEscudero(id_escudero);
		String sql = "DELETE FROM escuderos WHERE escuderos.ID_ESCUDERO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_escudero);
			prst.executeUpdate();
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	private static void desasignarCaballeroAEscudero(int id_escudero) {
		String sql = "UPDATE `escuderos` SET `ID_CABALLERO` = NULL WHERE `escuderos`.`ID_ESCUDERO` = ?;" ;
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_escudero);
			prst.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static Escudero getEscuderoByID(int id_escudero) {
		String sql = "SELECT * FROM escuderos WHERE escuderos.ID_ESCUDERO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_escudero);
			ResultSet rst = prst.executeQuery();
			if (rst.next()) {
				Escudero escudero = new Escudero();
				escudero.setId_escudero(rst.getInt("ID_ESCUDERO"));
				escudero.setId_caballero(rst.getInt("ID_CABALLERO"));
				escudero.setApellido(rst.getString("APELLIDO"));
				escudero.setNombre(rst.getString("NOMBRE"));
				escudero.setExperiencia(rst.getInt("EXPERIENCIA"));
				
				conector.deconectar();
				return escudero;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static boolean crearEscudero(Escudero escudero) {
		String sql = "INSERT INTO escuderos(NOMBRE,APELLIDO,EXPERIENCIA,ID_CABALLERO) VALUES(?,?,?,?)";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, escudero.getNombre());
			prst.setString(2, escudero.getApellido());
			prst.setInt(3, escudero.getExperiencia());
			prst.setInt(4, escudero.getId_caballero());
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Escudero getEscuderoByIDcaballero(int id_caballero) {
		String sql = "SELECT * FROM escuderos WHERE escuderos.ID_CABALLERO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_caballero);
			ResultSet rst = prst.executeQuery();
			if (rst.next()) {
				Escudero escudero = new Escudero();
				escudero.setId_escudero(rst.getInt("ID_ESCUDERO"));
				escudero.setId_caballero(rst.getInt("ID_CABALLERO"));
				escudero.setApellido(rst.getString("APELLIDO"));
				escudero.setNombre(rst.getString("NOMBRE"));
				escudero.setExperiencia(rst.getInt("EXPERIENCIA"));
				
				conector.deconectar();
				return escudero;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static boolean modificarEscudero(Escudero escudero) {
		String sql = "UPDATE escuderos SET NOMBRE=?,APELLIDO=?,EXPERIENCIA=?,ID_CABALLERO=? WHERE escuderos.ID_ESCUDERO=?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, escudero.getNombre());
			prst.setString(2, escudero.getApellido());
			prst.setInt(3, escudero.getExperiencia());
			prst.setInt(4, escudero.getId_caballero());
			prst.setInt(5, escudero.getId_escudero());
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static boolean evolucionarEscudero(Escudero escudero) {
	 String sql = "INSERT INTO caballeros(NOMBRE,APELLIDO,EXPERIENCIA,FUERZA) SELECT NOMBRE,APELLIDO,EXPERIENCIA,? FROM escuderos WHERE escuderos.ID_ESCUDERO=?;";
	 try {
		Conector conector = new Conector();
		PreparedStatement prst = conector.conectar().prepareStatement(sql);
		prst.setInt(1, escudero.getExperiencia()*2);
		prst.setInt(2, escudero.getId_escudero());
		prst.executeUpdate();
		conector.deconectar();
		return true;
	} catch (Exception e) {
		System.err.println(e);
	}
		return false;
	}
}
