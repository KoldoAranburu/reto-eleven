package modelo;

public class Escudo {
	private int id_escudo;
	private String nombre;
	private int nivel_defensa;
	public int getId_escudo() {
		return id_escudo;
	}
	public void setId_escudo(int id_escudos) {
		this.id_escudo = id_escudos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel_defensa() {
		return nivel_defensa;
	}
	public void setNivel_defensa(int i) {
		this.nivel_defensa = i;
	}
	@Override
	public String toString() {
		return "Escudo [id_escudos=" + id_escudo + ", nombre=" + nombre + ", nivel_defensa=" + nivel_defensa + "]";
	}
	
}
