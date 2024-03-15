package vista;

import java.util.Scanner;

import modelo.Arma;

public class Formulario {

	public static Arma pedirNuevosDatosArma(Arma arma, Scanner scan) {
		System.out.println("Introduzca el tipo de arma");
		arma.setTipo(scan.nextLine());

		System.out.println("Introduzca la fuerza de ataque del Arma");
		arma.setFuerza_ataque(Integer.parseInt(scan.nextLine()));
		return arma;
	}

	public static int pedirID(Scanner scan) {
		System.out.println("Introduzca el Id");
		int id = Integer.parseInt(scan.nextLine());
		return id;
	}

}
