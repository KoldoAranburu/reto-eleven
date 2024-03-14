package vista;

public class Menu {
	
	public static final int SALIR = 0;
	//PARA MENÚ DE USUARIO
	public static final int ELEGIR_CABALLERO = 1;
	public static final int COMENZAR_BATALLA = 2;
	
	//PARA MENÚ DE ADMINISTRADOR
	public static final int ADMINISTRAR_CABALLEROS = 1;
	public static final int ADMINISTRAR_ESCUDOS = 2;
	public static final int ADMINISTRAR_ARMAS = 3;
	public static final int ADMINISTRAR_CABALLOS = 4;
	public static final int ADMINISTRAR_ESCUDEROS = 5;
	
	//MENÚ DE CRUD
	public static final int CREAR_CABALLERO = 1;
	public static final int MODIFICAR_CABALLERO = 2;
	public static final int ELIMINAR_CABALLERO = 3;
	
	public static final int CREAR_ESCUDO = 1;
	public static final int MODIFICAR_ESCUDO = 2;
	public static final int ELIMINAR_ESCUDO = 3;
	
	public static final int CREAR_ARMA = 1;
	public static final int MODIFICAR_ARMA = 2;
	public static final int ELIMINAR_ARMA = 3;
	
	public static final int CREAR_CABALLO = 1;
	public static final int MODIFICAR_CABALLO = 2;
	public static final int ELIMINAR_CABALLO = 3;
	
	public static final int CREAR_ESCUDERO = 1;
	public static final int MODIFICAR_ESCUDERO = 2;
	public static final int ELIMINAR_ESCUDERO = 3;
	
	public static void menuPrincipal() {
		
	}
	
	public static void menuUsuario() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(ELEGIR_CABALLERO + ". ELEGIR CABALLERO.");
	}
	public static void menuBatallaUsuario() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(COMENZAR_BATALLA + ". COMENZAR BATALLA.");
	}
	public static void menuAdministrador() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(ADMINISTRAR_CABALLEROS + ". ADMINISTRAR CABALLEROS.");
		System.out.println(ADMINISTRAR_ESCUDOS + ". ADMINISTRAR ESCUDOS.");
		System.out.println(ADMINISTRAR_ARMAS + ". ADMINISTRAR ARMAS.");
		System.out.println(ADMINISTRAR_CABALLOS+ ". ADMINISTRAR CABALLOS.");
		System.out.println(ADMINISTRAR_ESCUDEROS + ". ADMINISTRAR ESCUDEROS.");
	}
	public static void menuCrudCaballero() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(CREAR_CABALLERO + ". CREAR CABALLERO.");
		System.out.println(MODIFICAR_CABALLERO + ". MODIFICAR CABALLERO.");
		System.out.println(ELIMINAR_CABALLERO + ". ELIMINAR CABALLERO.");
	}
	public static void menuCrudEscudo() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(CREAR_ESCUDO + ". CREAR ESCUDO.");
		System.out.println(MODIFICAR_ESCUDO + ". MODIFICAR ESCUDO.");
		System.out.println(ELIMINAR_ESCUDO + ". ELIMINAR ESCUDO.");
	}
	
}
