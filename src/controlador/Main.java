/*
	Esta clase Main se usa para Mostrar las dos posibles opciones a la hora 
	de que se ejecute la aplicacion dando al cliente la posibilidad de entrar como usuario 
	o como administrador, mediante el swicth case para manejar las diferentes opciones 
	y la clase Menu para visualizar el Menu de inicio, llamando al gestor adecuado en bas
	a la eleccion del cliente
*/

package controlador;

import java.util.Scanner;

import vista.Menu;

public class Main {

	public static void main(String[] args) {

		run();

	}

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			Menu.menuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.SALIR:
				System.out.println("Saliendo...");
				break;
			case Menu.USUARIO:
				GestorUsuario.run();
				break;
			case Menu.ADMIN:
				GestorAdministrador.run();
				break;
			default:
				System.out.println("Opción incorrecta, intentelo de nuevo.");
				break;
			}
			
		} while (opcion != Menu.SALIR);
	}
}
