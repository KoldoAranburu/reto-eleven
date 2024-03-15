package controlador;

import java.util.Scanner;

import vista.Menu;

public class GestorRoles {

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
