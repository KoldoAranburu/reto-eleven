package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.GestorArmas;
import modelo.Arma;
import modelo.ArmaModelo;
import modelo.Caballero;
import modelo.Caballo;
import modelo.Escudero;
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
	
//		System.out.println("Introduzca el id del arma");
//		caballero.setId_arma(Integer.parseInt(scan.nextLine()));
//		System.out.println("Introduzca el id del caballo");
//		caballero.setId_caballo(Integer.parseInt(scan.nextLine()));
//		System.out.println("Introduzca el id del escudo");
//		caballero.setId_escudo(Integer.parseInt(scan.nextLine()));
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



	public static Escudo pedirNuevosDatosEscudo(Escudo escudo, Scanner scan) {
		System.out.println("Inserte el nombre del escudo");
		escudo.setNombre(scan.nextLine());
		System.out.println("Inserte el Nivel del escudo");
		escudo.setNivel_defensa(Integer.parseInt(scan.nextLine()));
		return escudo;
	}

	public static Caballero asignarArma(Scanner scan, Caballero caballero) {
		System.out.println("Elija el id del arma a asignar");
		caballero.setId_arma(Integer.parseInt(scan.nextLine()));
		return caballero;
	}

	public static Caballero asignarEscudo(Scanner scan, Caballero caballero) {
		System.out.println("Introduzca el id del escudo a asignar");
		caballero.setId_escudo(Integer.parseInt(scan.nextLine()));
		return caballero;
	}

	public static Caballero asignarCaballo(Caballero caballero, Scanner scan) {
		System.out.println("Introduzca el id del caballo a asignar");
		caballero.setId_caballo(Integer.parseInt(scan.nextLine()));
		return caballero;
	}

	public static Caballo pedirNuevosDatosCaballo(Caballo caballo, Scanner scan) {
		System.out.println("Introduzca el color del caballo");
		caballo.setColor(scan.nextLine());

		System.out.println("Introduzca el nombre del caballo");
		caballo.setNombre(scan.nextLine());
		return caballo;
		}

	public static Escudero pedirNuevosDatosEscudero(Escudero escudero, Scanner scan) {
		
		System.out.println("Introduzca el nombre");
		escudero.setNombre(scan.nextLine());

		System.out.println("Introduzca el apellido");
		escudero.setApellido(scan.nextLine());
		
		
		System.out.println("Introduzca el experiencia");
		escudero.setExperiencia(Integer.parseInt(scan.nextLine()));
		return escudero;
	}
}
