/*
	El GestorAdministrador se usa para Mostrar las diferentes opciones que  que tiene 
	un administrador de la aplicaccion cuando, dando al cliente la posibilidad de poder Gestionar
	las altas bajas modificaciones de las tablas en la Base de datos, haciendo de puente entre
	los gestores para los caballeros,Armas,caballos y escuderos
*/


/*
  Los metodos que son publicos con para permitir la comunicacion entre los diferentes gestores
  ya que cda Gestor gestiona su clase y sus Atributos
*/

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
				GestorEscuderos.run();
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
