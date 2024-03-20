package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Caballero;
import modelo.Escudero;
import modelo.EscuderoModelo;
import modelo.EscudoModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorEscuderos {

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			Menu.menuCrudEscudero();
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.VER_ESCUDERO:
				 verEscudero(scan);
				break;
			case Menu.ELIMINAR_ESCUDERO:
				 eliminarEscudero(scan);
				break;
			case Menu.MODIFICAR_ESCUDERO:
				 modificarEscudero(scan);
				break;
			case Menu.CREAR_ESCUDERO:
				crearEscudero(scan);
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);
	}

	private static void crearEscudero(Scanner scan) {
		Escudero escudero = new Escudero();
		escudero = Formulario.pedirNuevosDatosEscudero(escudero, scan);
		escudero.setId_caballero(GestorEscuderos.asignarCaballero(scan));
		boolean estado_peticion =  EscuderoModelo.crearEscudero(escudero);
		
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error 809 Error al insertar Escudero en la Base de datos");
		} else {
			Visor.mostrarMensaje("Escudero creado Existosamente " + escudero.toString());
		}
	}

	private static void modificarEscudero(Scanner scan) {
		int id_escudero = Formulario.pedirID(scan);
		Escudero escudero = EscuderoModelo.getEscuderoByID(id_escudero);
		if (escudero == null) {
			Visor.mostrarMensaje("No esxiste escudero con ID: " + id_escudero);
		} else {
			Visor.mostrarEscudero(escudero);
			
			escudero = Formulario.pedirNuevosDatosEscudero(escudero,scan);
			escudero.setId_caballero(GestorEscuderos.asignarCaballero(scan));
			
			boolean estado_peticion = EscuderoModelo.modificarEscudero(escudero);
			if (estado_peticion=!true) {
				Visor.mostrarMensaje("Error al actualizar Escudero");
			} else {
				Visor.mostrarMensaje("Escudero Actualizado Correctamente" + escudero.toString());
			}
		}
	}


	private static void eliminarEscudero(Scanner scan) {
		int id_caballo = Formulario.pedirID(scan);
		boolean estado_peticion = EscuderoModelo.eliminarEscuderoByID(id_caballo);
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error 233 Error al borrar El caballero de la base de datos, Asegurate que no pertenezca a ningun caballero");
		} else {
			Visor.mostrarMensaje("Escudero con ID: " + id_caballo + " Eliminado");
		}
		
	}

	private static void verEscudero(Scanner scan) {
		ArrayList<Escudero> escuderos = EscuderoModelo.getEscuderos();
		Visor.mostrarEscuderos(escuderos);
	}
	
	private static int asignarCaballero(Scanner scan) {
		ArrayList<Caballero> caballeros =  GestorCaballeros.getCaballerosNoAsignados();
		Visor.mostrarCaballeros(caballeros);
		
		Visor.mostrarMensaje("Introduzca el Id del caballero a elegir");
		int id_caballero = Integer.parseInt(scan.nextLine());
		return id_caballero;
	}

	public static Escudero getEscuderoByIDCaballero(int id_caballero) {
		
		return EscuderoModelo.getEscuderoByIDcaballero(id_caballero);
	}

	public static boolean subirExperienciaEscudero(Escudero escuderoPJ1) {
		boolean estdo_peticion = EscuderoModelo.modificarEscudero(escuderoPJ1);
		
		return estdo_peticion;
	}

	public static void evolucionarEscudero(Caballero caballero) {
		Escudero escudero = getEscuderoByIDCaballero(caballero.getId_caballero());
		
		int max_experiencia_caballero = 97;
		
		if (escudero.getExperiencia()>max_experiencia_caballero) {
			
			boolean estado_peticion = EscuderoModelo.evolucionarEscudero(escudero);
			boolean estado_peticion2 = EscuderoModelo.eliminarEscuderoByID(escudero.getId_escudero());
		
			if (estado_peticion=! true && estado_peticion2==!true) {
				Visor.mostrarMensaje("Error Al evolucionar al Escudero");
			} else {
				Visor.mostrarMensaje("Enhorabuena tu Escudero " + escudero.getNombre() + ", Ahora es un caballero mas de la mesa Redonda, ya que ha superado la Experiencia Maxima");
			}			
		} else {
			Visor.mostrarMensaje("\t \n Tras la batalla los jueces han querido ascender al escudero " + escudero.getNombre() + ",  a caballero  pero todavia le falta experiencia para convertirse a un caballero !Animo");
		}
	}

}
