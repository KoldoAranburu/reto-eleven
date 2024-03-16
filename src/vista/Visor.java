package vista;

import java.util.ArrayList;

import modelo.Arma;
import modelo.Caballero;

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
}
