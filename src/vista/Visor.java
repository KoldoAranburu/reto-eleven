package vista;

import java.util.ArrayList;

import modelo.Arma;

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
}
