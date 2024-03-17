package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Escudo;
import modelo.EscudoModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorEscudos {
	private static void main(String[] args) {

		run();

	}

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			Menu.menuCrudEscudo();
			;
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.VER_ESCUDOS:
					verEscudo(scan);
				break;
			case Menu.CREAR_ESCUDO:
				crearEscudo(scan);
				break;
			case Menu.MODIFICAR_ESCUDO:
				modificarEscudo(scan);
				break;
			case Menu.ELIMINAR_ESCUDO:
				eliminarEscudo(scan);
				break;

			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);
		
	}

	private static void eliminarEscudo(Scanner scan) {
		int id_escudo = Formulario.pedirID(scan);
		boolean estdo_peticion= EscudoModelo.eliminarEscudoByID(id_escudo);
		if (estdo_peticion=!true) {
			Visor.mostrarMensaje("No existe Escudop con el ID: " + id_escudo);
		} else {
			Visor.mostrarMensaje("Escudo con ID: "+ id_escudo +", borrado");
		}
	}

	private static void modificarEscudo(Scanner scan) {
		int id_escudo = Formulario.pedirID(scan);
		Escudo escudo = new Escudo();
		escudo = EscudoModelo.getEscudoByID(id_escudo,escudo);
		if (escudo==null) {
			Visor.mostrarMensaje("No existe Escudo con ese ID: " + id_escudo);
		} else {
			Visor.mostrarMensaje("|_Modificar_|");
			Visor.mostrarEscudo(escudo);
			escudo=Formulario.pedirNuevosDatosEscudo(escudo, scan);
			
			boolean estado_peticion = EscudoModelo.actualizarEscudo(escudo);
			if (estado_peticion=!true) {
				Visor.mostrarMensaje("Error al actulizar el escudo en la Base de datos");
			} else {
				Visor.mostrarEscudo(escudo);
				Visor.mostrarMensaje("Escudo Actualizado con los nuevos valores");
			}
		}
	}

	private static void crearEscudo(Scanner scan) {
		Escudo escudo = new Escudo();
		escudo = Formulario.pedirNuevosDatosEscudo(escudo,scan);
		boolean estado_peticion = EscudoModelo.crearEscudo(escudo);
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error al insertar el escudo en la Base de Datos");
		} else {
			Visor.mostrarEscudo(escudo);
			Visor.mostrarMensaje("Escudo Creado Con Exito!");
		}
	}

	private static void verEscudo(Scanner scan) {
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		escudos=EscudoModelo.getEscudos(escudos);
		Visor.mostrarEscudos(escudos);
	}

	public static Escudo getEscudo(int id_escudo) {
		Escudo escudo = new Escudo();
		return EscudoModelo.getEscudoByID(id_escudo, escudo);
	}
}
