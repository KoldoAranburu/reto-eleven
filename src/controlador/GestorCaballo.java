/*
  Los metodos que son publicos con para permitir la comunicacion entre los diferentes gestores
  ya que cda Gestor gestiona su clase y sus Atributos
*/


package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Arma;
import modelo.ArmaModelo;
import modelo.Caballo;
import modelo.CaballoModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorCaballo {
	
	public static void run() {

		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			Menu.menuCrudCaballo();
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.CREAR_CABALLO:
				crearCaballo(scan);
				break;
			case Menu.MODIFICAR_CABALLO:
				modificarCaballo(scan);			
				break;
			case Menu.ELIMINAR_CABALLO:
				eliminarCaballo(scan);
			case Menu.VER_CABALLO:
				verCaballo(scan);
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);
	
	}
	private static void crearCaballo(Scanner scan) {
		Caballo caballo = new Caballo();
		caballo = Formulario.pedirNuevosDatosCaballo(caballo, scan);
		Boolean estato_peticion = CaballoModelo.crearCaballo(caballo);
		
		if (estato_peticion != true) {
			Visor.mostrarMensaje("Error al crear el arma");
		} else {
			Visor.mostrarMensaje("Caballo creado");
			Visor.mostrarCaballo(caballo);
		}
		
	}
	private static void modificarCaballo(Scanner scan) {
		Caballo caballo = new Caballo();
		int id_caballo = Formulario.pedirID(scan);
		caballo = CaballoModelo.getCaballoByID(id_caballo);
		if (caballo==null) {
			Visor.mostrarMensaje("No existe ningún caballo con la ID " + id_caballo);
		} else {
			Visor.mostrarCaballo(caballo);
			caballo = Formulario.pedirNuevosDatosCaballo(caballo, scan);
			boolean estado_peticion =  CaballoModelo.actualizarCaballo(caballo);
			if (estado_peticion=!true) {
				Visor.mostrarMensaje("Error al actualizar arma");
			} else {
				Visor.mostrarMensaje("Caballo Actualizado Correctamente");
				Visor.mostrarCaballo(caballo);
			}
		}
		
	}
	private static void eliminarCaballo(Scanner scan) {
		int id_caballo = Formulario.pedirID(scan);
		Boolean estado_peticion =  CaballoModelo.borrarCaballo(id_caballo);
		
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error al eliminar el arma");
		}else {
			Visor.mostrarMensaje("Caballo con ID " + id_caballo + " Eliminado.");
		}
		
	}
	private static void verCaballo(Scanner scan) {
		ArrayList<Caballo> caballos = new ArrayList<Caballo>();
		caballos = CaballoModelo.getCaballos(caballos);
		if (caballos == null) {
			Visor.mostrarMensaje("Error al cargar las Armas desde la Base de datos");
		} else {
			Visor.mostrarCaballos(caballos);
		}
	}
}
