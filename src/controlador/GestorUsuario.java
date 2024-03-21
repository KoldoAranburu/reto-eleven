/*
    Los gestores tiene un menu para poder realizar las operaciones CRUD
    y hace uso de la clase "Ej: CaballeroModelo" para para hacer las 
    operaciones CRUD usando el gestor solo para recoger los inputs 
    del cliente por pantalla y llamando a su clase correspondiente que
    Hcae la conexion de la Base de datos con la sentencia y devuelve "True"
    si se ha completado la sentencia y "FALSE" si ha encontrado un error
*/

/*
  Los metodos que son publicos con para permitir la comunicacion entre los diferentes gestores
  ya que cda Gestor gestiona su clase y sus Atributos
*/

package controlador;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import modelo.Arma;
import modelo.Batallar;
import modelo.Caballero;
import modelo.Escudo;
import vista.Formulario;
import vista.GameOver;
import vista.GanadorGUI;
import vista.Menu;
import vista.Visor;

public class GestorUsuario {


	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			Menu.menuUsuario();
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.INICIAR_JUEGO:
				iniciarJuego();
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);

	}

	public static void iniciarJuego() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Caballero> caballeros = caballeros = GestorCaballeros.getCaballeros();
		ArrayList<Arma> armas =  GestorArmas.getArmas();
		
		Random random = new Random();
		LocalDate fecha = LocalDate.now();
		
		Visor.mostrarMensaje("Elige personaje:");
		int id_caballero = Formulario.pedirID(scan);

		Caballero caballeroPJ1= Batallar.getPrimerLuchador(id_caballero);
		Caballero caballeroPJ2= Batallar.getSecundoluchador(caballeros,random);
		
		if (caballeroPJ1.getId_caballero()==caballeroPJ2.getId_caballero()) {
			caballeroPJ2= Batallar.getSecundoluchador(caballeros,random);
		}
		Visor.mostrarMensaje("Lucharas contra -> " + caballeroPJ2.toString() + "\t");
		Caballero ganador =  Batallar.luchar(caballeroPJ1, caballeroPJ2,armas);
		
		if (ganador.getId_caballero()==caballeroPJ1.getId_caballero()) {
			Visor.mostrarMensaje("\n Has ganado caballero -> " + caballeroPJ1.toString());
			
			Visor.mostrarMensaje("\t \n -> HE AQUI LA RECOMPENSA DE LA BATALLA");
			Visor.mostrarArmas(armas);
			
			Visor.mostrarMensaje("Elija el ID del arma");
			int id_arma = Integer.parseInt(scan.nextLine());
			
			caballeroPJ1.setId_arma(id_arma);
			GestorCaballeros.actualizarCaballero(caballeroPJ1);
			
		} else if(ganador.getId_caballero()==caballeroPJ2.getId_caballero()){
			Visor.mostrarMensaje("Has perdido de manera alucinante contra -> " + caballeroPJ2.toString());
			
		}else {
			Visor.mostrarMensaje("Declaramos un EMPATE!");
		}
		
		boolean estado_peticion = GestorCaballeros.subirBatalla(caballeroPJ1,caballeroPJ2,ganador,fecha);
	
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error 188: Fallo al Guardar Los Datos en La base de Datos");
		} else {
			Visor.mostrarMensaje("Batala Guardada en los Libros de la Historia");
		}
		
		
		GestorEscuderos.evolucionarEscudero(ganador);
		
	}

	public static ArrayList<Arma> batallarGUI(Caballero caballeroPJ1, ArrayList<Caballero> caballeros) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Arma> armas =  GestorArmas.getArmas();
		
		Random random = new Random();
		LocalDate fecha = LocalDate.now();

		Caballero caballeroPJ2= Batallar.getSecundoluchador(caballeros,random);
		
		if (caballeroPJ1.getId_caballero()==caballeroPJ2.getId_caballero()) {
			caballeroPJ2= Batallar.getSecundoluchador(caballeros,random);
		}
		Visor.mostrarMensaje("Lucharas contra -> " + caballeroPJ2.toString() + "\t");
		Caballero ganador =  Batallar.luchar(caballeroPJ1, caballeroPJ2,armas);
		
		if (ganador.getId_caballero()==caballeroPJ1.getId_caballero()) {
			Visor.mostrarMensaje("\n Has ganado caballero -> " + caballeroPJ1.toString());
			
			Visor.mostrarMensaje("\t \n -> HE AQUI LA RECOMPENSA DE LA BATALLA");
			Visor.mostrarArmas(armas);
			
			Visor.mostrarMensaje("Elija el ID del arma");
			GanadorGUI.mostarLoot(caballeroPJ1,armas);
			return armas;
			
		} else if(ganador.getId_caballero()==caballeroPJ2.getId_caballero()){
			Visor.mostrarMensaje("Has perdido de manera alucinante contra -> " + caballeroPJ2.toString());
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GameOver window = new GameOver();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}else {
			Visor.mostrarMensaje("Declaramos un EMPATE!");
		}
		
		boolean estado_peticion = GestorCaballeros.subirBatalla(caballeroPJ1,caballeroPJ2,ganador,fecha);
		
		if (estado_peticion=!true) {
			Visor.mostrarMensaje("Error 188: Fallo al Guardar Los Datos en La base de Datos");
		} else {
			Visor.mostrarMensaje("Batala Guardada en los Libros de la Historia");
		}
		
		return null;
		

	}
}

