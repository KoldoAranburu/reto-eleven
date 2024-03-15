package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Arma;
import modelo.ArmaModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorArmas {
	private static void main(String[] args) {

		run();

	}

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			Menu.menuCrudArma();
			;
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.CREAR_ARMA:
				crearArma(scan);
				break;
			case Menu.ELIMINAR_ARMA:
				eliminarArama(scan);
				break;
			case Menu.MODIFICAR_ARMA:
				modificarArma(scan);
				break;
			case Menu.VER_ARMAS:
				verArmas(scan);
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);
	}

	private static void verArmas(Scanner scan) {
		ArrayList<Arma> armas = new ArrayList<Arma>();
		armas = ArmaModelo.getArmas(armas);
		if (armas == null) {
			Visor.mostrarMensaje("Error al cargar las Armas desde la Base de datos");
		} else {
			Visor.mostrarArmas(armas);
		}
	}

	private static void modificarArma(Scanner scan) {
		Arma arma = new Arma();
		int id_arma = Formulario.pedirID(scan);
		arma = ArmaModelo.getArmaByID(id_arma);
		if (arma==null) {
			Visor.mostrarMensaje("No existe una arma con la ID " + id_arma);
		} else {
			Visor.mostrarArma(arma);
			arma = Formulario.pedirNuevosDatosArma(arma, scan);
			boolean estado_peticion =  ArmaModelo.actualizarArma(arma);
			if (estado_peticion=!true) {
				Visor.mostrarMensaje("Error al actualizar arma");
			} else {
				Visor.mostrarMensaje("Arma Actualizado Correctamente");
				Visor.mostrarArma(arma);
			}
		}
	}

	private static void eliminarArama(Scanner scan) {
		int id_arma = Formulario.pedirID(scan);
		Boolean estado_peticion =  ArmaModelo.borrarArma(id_arma);
		
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error al eliminar el arma");
		}else {
			Visor.mostrarMensaje("Arma con ID " + id_arma + " Eliminado.");
		}
	}

	private static void crearArma(Scanner scan) {
		Arma arma = new Arma();
		arma = Formulario.pedirNuevosDatosArma(arma, scan);
		Boolean estato_peticion = ArmaModelo.crearArma(arma);
		
		if (estato_peticion != true) {
			Visor.mostrarMensaje("Error al crear el arma");
		} else {
			Visor.mostrarMensaje("Arma creada");
			Visor.mostrarArma(arma);
		}
	}
}
