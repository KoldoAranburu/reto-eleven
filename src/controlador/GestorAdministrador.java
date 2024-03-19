package controlador;

import java.util.Scanner;

import vista.Menu;

public class GestorAdministrador {

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			Menu.menuAdministrador();
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.ADMINISTRAR_ARMAS:
				GestorArmas.run();
				break;
			case Menu.ADMINISTRAR_CABALLEROS:
				GestorCaballeros.run();			
				break;
			case Menu.ADMINISTRAR_CABALLOS:
				GestorCaballo.run();
				break;
			case Menu.ADMINISTRAR_ESCUDEROS:
				//segundo Split
				break;
			case Menu.ADMINISTRAR_ESCUDOS:
				GestorEscudos.run();
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
		} while (opcion != Menu.SALIR);
	}
}
