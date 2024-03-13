package modelo;

public class Caballo {
	private int id_caballo;
	private String color;
	private String nombre;
	public int getId_caballo() {
		return id_caballo;
	}
	public void setId_caballo(int id_caballo) {
		this.id_caballo = id_caballo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Caballo [id_caballo=" + id_caballo + ", color=" + color + ", nombre=" + nombre + "]";
	}
	
}
