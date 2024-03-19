package controlador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modelo.Arma;
import modelo.Batallar;
import modelo.Caballero;
import modelo.Escudo;
import vista.Formulario;
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
				iniciarJuego(scan);
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);

	}

	private static void iniciarJuego(Scanner scan) {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros = GestorCaballeros.getCaballeros();
		Random random = new Random();

		Visor.mostrarMensaje("Elige personaje:");
		int id_caballero = Formulario.pedirID(scan);

		Caballero caballeroPJ1= Batallar.getPrimerLuchador(caballeros,id_caballero);
		Caballero caballeroPJ2= Batallar.getSecundoluchador(caballeros,random);
		
		if (caballeroPJ1.getId_caballero()==caballeroPJ2.getId_caballero()) {
			caballeroPJ2= Batallar.getSecundoluchador(caballeros,random);
		}
		Visor.mostrarMensaje("Lucharas contra -> " + caballeroPJ2.toString() + "/t");
		String resultado =  Batallar.luchar(caballeroPJ1.calcularFuerzaLucha(), caballeroPJ2.calcularFuerzaLucha(), caballeroPJ1, caballeroPJ2);
		
		Visor.mostrarMensaje(resultado);
		
		int estado_peticion = GestorCaballeros.subirBatalla(caballeroPJ1,caballeroPJ2);
	}
}

