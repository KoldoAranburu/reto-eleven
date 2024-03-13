package modelo;

public class Arma {
	private int id_arma;
	private String tipo;
	private String fuerza_ataque;
	public int getId_arma() {
		return id_arma;
	}
	public void setId_arma(int id_arma) {
		this.id_arma = id_arma;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFuerza_ataque() {
		return fuerza_ataque;
	}
	public void setFuerza_ataque(String fuerza_ataque) {
		this.fuerza_ataque = fuerza_ataque;
	}
	@Override
	public String toString() {
		return "Arma [id_arma=" + id_arma + ", tipo=" + tipo + ", fuerza_ataque=" + fuerza_ataque + "]";
	}
	
}
