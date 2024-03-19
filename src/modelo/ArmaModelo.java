package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class ArmaModelo {

	public static Boolean crearArma(Arma arma) {
		String sql = "INSERT INTO armas(TIPO,FUERZA_ATAQUE) values(?,?);";
		Conector conector = new Conector();
		try {
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setString(1, arma.getTipo());
			prst.setInt(2, arma.getFuerza_ataque());
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Boolean borrarArma(int id_arma) {
		String sql = "DELETE FROM armas WHERE armas.ID_ARMA = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_arma);
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static boolean actualizarArma(Arma arma) {
		String sql = "UPDATE armas SET TIPO = ?, FUERZA_ATAQUE= ? WHERE armas.ID_ARMA = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);

			prst.setString(1, arma.getTipo());
			prst.setInt(2, arma.getFuerza_ataque());
			prst.setInt(3, arma.getId_arma());
			prst.executeUpdate();
			
			conector.deconectar();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public static Arma getArmaByID(int id_arma) {
		String sql = "SELECT * FROM armas WHERE armas.ID_ARMA = ?";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			prst.setInt(1, id_arma);
			ResultSet rst = prst.executeQuery();
			if (rst.next()) {
				Arma arma = new Arma();
				arma.setFuerza_ataque(rst.getInt("FUERZA_ATAQUE"));
				arma.setId_arma(rst.getInt("ID_ARMA"));
				arma.setTipo(rst.getString("TIPO"));
				
				conector.deconectar();
				return arma;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static ArrayList<Arma> getArmas(ArrayList<Arma> armas) {
		String sql = "SELECT * FROM armas";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Arma arma = new Arma();
				arma.setFuerza_ataque(rst.getInt("FUERZA_ATAQUE"));
				arma.setId_arma(rst.getInt("ID_ARMA"));
				arma.setTipo(rst.getString("TIPO"));
				armas.add(arma);
			}
			
			conector.deconectar();
			return armas;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public static ArrayList<Arma> getArmasNoAsignadas(ArrayList<Arma> armas) {
		String sql = "SELECT * FROM armas WHERE armas.ID_ARMA NOT IN (SELECT a.ID_ARMA FROM armas A JOIN caballeros B ON A.ID_ARMA=b.ID_ARMA);";
		try {
			Conector conector = new Conector();
			PreparedStatement prst = conector.conectar().prepareStatement(sql);
			ResultSet rst = prst.executeQuery();
			while(rst.next()) {
				Arma arma = new Arma();
				arma.setFuerza_ataque(rst.getInt("FUERZA_ATAQUE"));
				arma.setId_arma(rst.getInt("ID_ARMA"));
				arma.setTipo(rst.getString("TIPO"));
				armas.add(arma);
			}
			
			conector.deconectar();
			return armas;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
