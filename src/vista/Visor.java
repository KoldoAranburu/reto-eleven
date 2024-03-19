package vista;

import java.util.ArrayList;

import modelo.Arma;
import modelo.Caballero;
import modelo.Caballo;
import modelo.Escudero;
import modelo.Escudo;

public class Visor {

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static void mostrarArma(Arma arma) {
		System.out.println(arma);
	}

	public static void mostrarArmas(ArrayList<Arma> armas) {
		for (Arma arma : armas) {
			System.out.println(arma);
		}
	}

	public static void mostrarCaballeros(ArrayList<Caballero> caballeros) {
		for (Caballero caballero : caballeros) {
			System.out.println(caballero);
		}
	}

	public static void mostrarEscudos(ArrayList<Escudo> escudos) {
		for (Escudo escudo : escudos) {
			System.out.println(escudo);
		}
		
	}

	public static void mostrarEscudo(Escudo escudo) {
		System.out.println(escudo);
		
	}

	public static void mostrarCaballero(Caballero caballero) {
		System.out.println(caballero);
	}

	public static void mostrarCaballos(ArrayList<Caballo> caballos) {
		for (Caballo caballo : caballos) {
			System.out.println(caballo);
		}
		
	}

	public static void mostrarEscuderos(ArrayList<Escudero> escuderos) {
		for (Escudero escudero : escuderos) {
			System.out.println(escudero);
		}
		
	}

	public static void mostrarEscudero(Escudero escudero) {
		System.out.println(escudero);
	}
}
