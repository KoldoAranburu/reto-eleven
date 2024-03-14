package modelo;

import java.sql.ResultSet;
import java.sql.Statement;

public class EscudoModelo extends Conector{
	public void juagar() {
		Conector con = new Conector();
		try {
			String sql = "SELECT * FROM caballeros";
			Statement st = conectar().prepareStatement(sql);
			ResultSet rst = st.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
