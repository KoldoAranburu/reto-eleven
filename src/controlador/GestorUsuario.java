package controlador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modelo.Arma;
import modelo.Caballero;
import modelo.Escudo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorUsuario {
	public static void main(String[] args) {

		run();

	}

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

		for (Caballero caballero : caballeros) {
			if (caballero.getId_caballero() == id_caballero) {
				Caballero caballero2 = caballeros.get(random.nextInt(0, caballeros.size()));
				Visor.mostrarMensaje("Lucharas contra -> " + caballero2.toString() + "/t");
				luchar(calcularFuerzaLuchaPJ1(caballero), calcularFuerzaLuchaPJ2(caballero2), caballero, caballero2);
			}
		}

	}

	private static void luchar(int calculoFuerzaLuchaPJ1, int calculoFuerzaLuchaPJ2, Caballero caballero,
			Caballero caballero2) {
		Random random = new Random();
//		Cálculo de la Fuerza de lucha (FL): 
//
//			(fuerza habilidad + ataque del arma +defensa del escudo) 
//
//			FL1*random(1 , experiencia)  - FL2 * random(1, experiencia) > 10 por ejemplo  ->gana el Caballero 1
//
//			FL1*random(1 , experiencia)  - FL2 * random(1, experiencia) < 10 por ejemplo  ->gana el Caballero 2
//
//			Si no es empate.
		int estocadaPJ1 = calculoFuerzaLuchaPJ1*random.nextInt(1, caballero.getExperiencia());
		int estocadaPJ2 = calculoFuerzaLuchaPJ2*random.nextInt(1, caballero2.getExperiencia());
		
		if (estocadaPJ1-estocadaPJ2>10) {
			Visor.mostrarMensaje("\n Has ganado caballero -> " + caballero.toString());
		}else if(estocadaPJ1-estocadaPJ2<10) {
			Visor.mostrarMensaje("Has perdido de manera alucinante contra -> " + caballero2.toString());
		}
	}

	private static int calcularFuerzaLuchaPJ2(Caballero caballero2) {
		Arma arma = new Arma();
		Escudo escudo = new Escudo();
		arma = GestorArmas.getArma(caballero2.getId_escudo());
		escudo = GestorEscudos.getEscudo(caballero2.getId_escudo());

		int fuerza_lucha_PJ2 = caballero2.getFuerza() + arma.getFuerza_ataque() + escudo.getNivel_defensa();
		return fuerza_lucha_PJ2;
	}

	private static int calcularFuerzaLuchaPJ1(Caballero caballero) {

		Arma arma = new Arma();
		Escudo escudo = new Escudo();
		arma = GestorArmas.getArma(caballero.getId_escudo());
		escudo = GestorEscudos.getEscudo(caballero.getId_escudo());

		int fuerza_lucha_PJ1 = caballero.getFuerza() + arma.getFuerza_ataque() + escudo.getNivel_defensa();
		return fuerza_lucha_PJ1;
	}
}
