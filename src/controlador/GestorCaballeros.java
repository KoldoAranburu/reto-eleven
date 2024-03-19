package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Arma;
import modelo.ArmaModelo;
import modelo.Caballero;
import modelo.CaballeroModelo;
import modelo.Caballo;
import modelo.CaballoModelo;
import modelo.Escudo;
import modelo.EscudoModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorCaballeros {
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
				modificarCaballero(scan);
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

	private static void modificarCaballero(Scanner scan) {
		int id_caballero = Formulario.pedirID(scan);
		Caballero caballero = new Caballero();
		ArrayList<Arma> armas = new ArrayList<Arma>();
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		ArrayList<Caballo> caballos = new ArrayList<Caballo>();
		
		caballero = CaballeroModelo.getCaballeroByID(id_caballero,caballero);
		if (caballero==null) {
			Visor.mostrarMensaje("No Existe un Caballero con esos parametros ID: " + id_caballero);
		} else {
			Visor.mostrarCaballero(caballero);
			
			Visor.mostrarMensaje("|_Modificar_|");
			caballero = Formulario.pedirNuevosDatosCaballero(scan, caballero);
			
			armas = ArmaModelo.getArmasNoAsignadas(armas);
			Visor.mostrarArmas(armas);
			caballero = Formulario.asignarArma(scan, caballero);
			
			escudos = EscudoModelo.getEscudosNoAsignados(escudos);
			Visor.mostrarEscudos(escudos);
			caballero = Formulario.asignarEscudo(scan, caballero);
			
			caballos = CaballoModelo.getCaballosNoAsignados(caballos);
			Visor.mostrarCaballos(caballos);
			caballero = Formulario.asignarCaballo(caballero,scan);
			
			boolean estado_peticion = CaballeroModelo.modificarCaballero(caballero);
			if (estado_peticion=!true) {
				Visor.mostrarMensaje("Error al actualizar caballero en la base de datos");
			} else {
				Visor.mostrarCaballero(caballero);
				Visor.mostrarMensaje("Caballero Actualizado Correctamente");
			}
		}
	}


	private static void crearCaballero(Scanner scan) {
		Caballero caballero = new Caballero();
		ArrayList<Arma> armas = new ArrayList<Arma>();
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		ArrayList<Caballo> caballos = new ArrayList<Caballo>();
		
		caballero = Formulario.crearCaballero(scan, caballero);

		armas = ArmaModelo.getArmasNoAsignadas(armas);
		Visor.mostrarArmas(armas);
		caballero = Formulario.asignarArma(scan, caballero);
		
		escudos = EscudoModelo.getEscudosNoAsignados(escudos);
		Visor.mostrarEscudos(escudos);
		caballero = Formulario.asignarEscudo(scan, caballero);
		
		caballos = CaballoModelo.getCaballosNoAsignados(caballos);
		Visor.mostrarCaballos(caballos);
		caballero = Formulario.asignarCaballo(caballero,scan);
		
		Boolean estado_peticion = CaballeroModelo.crearCaballero(caballero);

		if (estado_peticion = !true) {
			Visor.mostrarMensaje("Error al insertar el caballero en la Base de Datos");
		} else {
			Visor.mostrarCaballero(caballero);
			Visor.mostrarMensaje("Caballero Insertado con Exito");
		}
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
	
	private static void verCaballeros(Scanner scan) {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros = CaballeroModelo.getCaballeros(caballeros);
		if (caballeros == null) {
			Visor.mostrarMensaje("Error al cargar los caballeros de la base de datos");
		} else {
			Visor.mostrarCaballeros(caballeros);
		}
	}

	public static ArrayList<Caballero> getCaballeros() {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros = CaballeroModelo.getCaballeros(caballeros);
		if (caballeros == null) {
			Visor.mostrarMensaje("Error al cargar los caballeros de la base de datos");
		} else {
			Visor.mostrarCaballeros(caballeros);
		}
		return caballeros;
	}
	
	public static boolean subirBatalla(Caballero caballeroPJ1, Caballero caballeroPJ2, Caballero ganador, LocalDate fecha) {
		boolean estado_peticion = CaballeroModelo.subirBatalla(caballeroPJ1,caballeroPJ2,ganador,fecha);
		return estado_peticion;
	}
}
