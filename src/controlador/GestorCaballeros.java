package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Arma;
import modelo.ArmaModelo;
import modelo.Caballero;
import modelo.CaballeroModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorCaballeros {

	private static void main(String[] args) {

		run();

	}

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			Menu.menuCrudCaballero();
			;
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.VER_CABALLERO:
				verCaballeros(scan);
				break;
			case Menu.CREAR_CABALLERO:
				crearCaballero(scan);
				break;
			case Menu.MODIFICAR_CABALLERO:
				// modificarCaballero();
				break;
			case Menu.ELIMINAR_CABALLERO:
				eliminarCaballero(scan);
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);

	}

	private static void eliminarCaballero(Scanner scan) {
		int id_caballero = Formulario.pedirID(scan);
		boolean estado_peticion = CaballeroModelo.eliminarCaballero(id_caballero);
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Cabllero con Id" + id_caballero + "Eliminado!");
		} else {
			Visor.mostrarMensaje("Error al borrar caballero recuerda quitar complementos al caballero para poder borrarlo");
		}
	}

	private static void crearCaballero(Scanner scan) {
		Caballero caballero = new Caballero();
		ArrayList<Arma> armas = new ArrayList<Arma>();

		caballero = Formulario.crearCaballero(scan, caballero);

		armas = ArmaModelo.getArmasNoAsignadas(armas);
		Visor.mostrarArmas(armas);

		caballero = Formulario.asignarComplementosCaballero(scan, caballero);
		Boolean estado_peticion = CaballeroModelo.crearCaballero(caballero);

		if (estado_peticion = !true) {
			Visor.mostrarMensaje("Error al insertar el caballero en la Base de Datos");
		} else {
			Visor.mostrarMensaje("Caballero Insertado con Exito");
		}
	}

	private static void verCaballeros(Scanner scan) {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros = CaballeroModelo.getCaballeros(caballeros);
		if (caballeros == null) {
			Visor.mostrarMensaje("Error al cargar los caballeros de la base de datos");
		} else {
			Visor.mostrarCaballeros(caballeros);
		}
	}
}
