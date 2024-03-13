package modelo;

public class Caballero {
	private String nombre;
	private String apellido;
	private int fuerza;
	private int experiencia;
	private int id_caballero;
	private int id_escudo;
	private int id_caballo;
	private int id_arma;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public int getId_caballero() {
		return id_caballero;
	}
	public void setId_caballero(int id_caballero) {
		this.id_caballero = id_caballero;
	}
	public int getId_escudo() {
		return id_escudo;
	}
	public void setId_escudo(int id_escudo) {
		this.id_escudo = id_escudo;
	}
	public int getId_caballo() {
		return id_caballo;
	}
	public void setId_caballo(int id_caballo) {
		this.id_caballo = id_caballo;
	}
	public int getId_arma() {
		return id_arma;
	}
	public void setId_arma(int id_arma) {
		this.id_arma = id_arma;
	}
	@Override
	public String toString() {
		return "Caballero [nombre=" + nombre + ", apellido=" + apellido + ", fuerza=" + fuerza + ", experiencia="
				+ experiencia + ", id_caballero=" + id_caballero + ", id_escudo=" + id_escudo + ", id_caballo="
				+ id_caballo + ", id_arma=" + id_arma + "]";
	}
	
	
}
