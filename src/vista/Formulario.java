package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.GestorArmas;
import modelo.Arma;
import modelo.ArmaModelo;
import modelo.Caballero;
import modelo.Caballo;
import modelo.Escudo;

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

	public static Caballero pedirNuevosDatosCaballero(Scanner scan, Caballero caballero) {
		System.out.println("Introduzca el nombre");
		caballero.setNombre(scan.nextLine());
		System.out.println("Introduzca el apellido");
		caballero.setApellido(scan.nextLine());
		System.out.println("Introduzca el experiencia");
		caballero.setExperiencia(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduzca el fuerza");
		caballero.setFuerza(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduzca el id del arma");
		caballero.setId_arma(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduzca el id del caballo");
		caballero.setId_caballo(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduzca el id del escudo");
		caballero.setId_escudo(Integer.parseInt(scan.nextLine()));
		return caballero;
	}

	public static Caballero crearCaballero(Scanner scan, Caballero caballero) {
		System.out.println("Introduzca el nombre");
		caballero.setNombre(scan.nextLine());
		System.out.println("Introduzca el apellido");
		caballero.setApellido(scan.nextLine());
		System.out.println("Introduzca el nivel de experiencia");
		caballero.setExperiencia(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduzca el nivel de fuerza");
		caballero.setFuerza(Integer.parseInt(scan.nextLine()));
		return caballero;
	}

	public static Caballero asignarComplementosCaballero(Scanner scan, Caballero caballero) {
		System.out.println("Elija el id del arma a asignar");
		caballero.setId_arma(Integer.parseInt(scan.nextLine()));
		//ELEGIR la ID de los caballos Disponibles
		System.out.println("Introduzca el id del caballo a asignar");
		//ELEGIR la ID de las caballos Disponibles
		caballero.setId_caballo(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduzca el id del escudo a asignar");
		//ELEGIR la ID de los escudos Disponibles
		caballero.setId_escudo(Integer.parseInt(scan.nextLine()));
		return caballero;
	}

	public static Escudo pedirNuevosDatosEscudo(Escudo escudo, Scanner scan) {
		System.out.println("Inserte el nombre del escudo");
		escudo.setNombre(scan.nextLine());
		System.out.println("Inserte el Nivel del escudo");
		escudo.setNivel_defensa(Integer.parseInt(scan.nextLine()));
		return escudo;
	}
}
