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
			return escuderos;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static boolean eliminarEscuderoByID(int id_caballo) {
		String sql = "DELETE FROM escuderos WHERE escuderos.ID_ESCUDERO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_caballo);
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Escudero getEscuderoByID(int id_escudero) {
		String sql = "SELECT * FROM escuderos WHERE escuderos.ID_ESCUDRO = ?";
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
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
}
