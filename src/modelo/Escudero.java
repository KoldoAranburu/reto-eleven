package modelo;

public class Escudero {
	private int id_escudero;
	private String nombre;
	private String apellido;
	private int experiencia;
	private int id_caballero;
	public int getId_escudero() {
		return id_escudero;
	}
	public void setId_escudero(int id_escudero) {
		this.id_escudero = id_escudero;
	}
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
	@Override
	public String toString() {
		return "Escudero [id_escudero=" + id_escudero + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", experiencia=" + experiencia + ", id_caballero=" + id_caballero + "]";
	}
	
}
