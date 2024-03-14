package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	private final static String BBDD = "reto_caballeros";
	private final static String USUARIO="root";
	private final static String CONTRASEÑA ="";
	private final static String HOST = "localhost";
	private static Connection CONEXIONBBDD = null;
	
	private Conector() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			CONEXIONBBDD = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD,USUARIO,CONTRASEÑA);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	private Connection getConexion() {
		return CONEXIONBBDD;
	}
	private void deconectar() {
		try {
			CONEXIONBBDD.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
