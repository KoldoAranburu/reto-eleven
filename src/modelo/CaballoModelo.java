package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CaballoModelo {

	public static ArrayList<Caballo> getCaballosNoAsignados(ArrayList<Caballo> caballos) {
		String sql = "SELECT * FROM caballos WHERE caballos.ID_CABALLO NOT IN (SELECT a.ID_CABALLO FROM caballos A JOIN caballeros B ON A.ID_CABALLO=b.ID_CABALLO);";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Caballo caballo = new Caballo();
				caballo.setColor(rst.getString("COLOR"));
				caballo.setId_caballo(rst.getInt("ID_CABALLO"));
				caballo.setNombre(rst.getString("NOMBRE"));
				caballos.add(caballo);
			}
			return caballos;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static ArrayList<Caballo> getCaballos(ArrayList<Caballo> caballos) {
		String sql = "SELECT * FROM caballos";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Caballo caballo = new Caballo();
				caballo.setId_caballo(rst.getInt("ID_CABALLO"));
				caballo.setColor(rst.getString("COLOR"));
				caballo.setNombre(rst.getString("NOMBRE"));
				caballos.add(caballo);
			}
			return caballos;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static Boolean borrarCaballo(int id_caballo) {
		String sql = "DELETE FROM caballos WHERE caballos.ID_CABALLO = ?";
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

	public static Caballo getCaballoByID(int id_caballo) {
		String sql = "SELECT * FROM caballos WHERE caballos.ID_CABALLO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_caballo);
			ResultSet rst = prst.executeQuery();
			if (rst.next()) {
				Caballo caballo = new Caballo();
				caballo.setId_caballo(rst.getInt("ID_CABALLO"));
				caballo.setColor(rst.getString("COLOR"));
				caballo.setNombre(rst.getString("NOMBRE"));
				return caballo;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static boolean actualizarCaballo(Caballo caballo) {
		String sql = "UPDATE caballos SET COLOR = ?, NOMBRE= ? WHERE caballos.ID_CABALLO = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);

			prst.setString(1, caballo.getColor());
			prst.setString(2, caballo.getNombre());
			prst.setInt(3, caballo.getId_caballo());
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Boolean crearCaballo(Caballo caballo) {
		String sql = "INSERT INTO caballos(COLOR,NOMBRE) values(?,?);";
		Conector conector = new Conector();
		try {
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, caballo.getColor());
			prst.setString(2, caballo.getNombre());
			prst.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

}
