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

}
