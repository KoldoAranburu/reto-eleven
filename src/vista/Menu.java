package vista;

public class Menu {
	
	public static final int SALIR = 0;
	
	//MENU PRINCIPAL
	public static final int ADMIN = 2;
	public static final int USUARIO = 1;
	
	//PARA MENÚ DE USUARIO
	public static final int ELEGIR_CABALLERO = 1;
	public static final int INICIAR_JUEGO = 1;
	
	//PARA MENÚ DE ADMINISTRADOR
	public static final int ADMINISTRAR_CABALLEROS = 1;
	public static final int ADMINISTRAR_ESCUDOS = 2;
	public static final int ADMINISTRAR_ARMAS = 3;
	public static final int ADMINISTRAR_CABALLOS = 4;
	public static final int ADMINISTRAR_ESCUDEROS = 5;
	
	//MENÚ DE CRUD
	public static final int VER_CABALLERO = 1;
	public static final int CREAR_CABALLERO = 2;
	public static final int MODIFICAR_CABALLERO = 3;
	public static final int ELIMINAR_CABALLERO = 4;
	
	public static final int VER_ESCUDOS = 1;
	public static final int CREAR_ESCUDO = 2;
	public static final int MODIFICAR_ESCUDO = 3;
	public static final int ELIMINAR_ESCUDO = 4;
	
	public static final int VER_ARMAS = 1;
	public static final int CREAR_ARMA = 2;
	public static final int MODIFICAR_ARMA = 3;
	public static final int ELIMINAR_ARMA = 4;
	
	public static final int CREAR_CABALLO = 1;
	public static final int MODIFICAR_CABALLO = 2;
	public static final int ELIMINAR_CABALLO = 3;
	
	public static final int CREAR_ESCUDERO = 2;
	public static final int MODIFICAR_ESCUDERO = 3;
	public static final int ELIMINAR_ESCUDERO = 4;
	
	public static void menuPrincipal() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(USUARIO + ". ACCEDER COMO USUARIO.");
		System.out.println(ADMIN + ". ACCEDER COMO ADMINISTRADOR.");
	}
	
	public static void menuUsuario() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(INICIAR_JUEGO + ". INICIAR JUEGO.");
	}
	public static void menuBatallaUsuario() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(ELEGIR_CABALLERO + ". SELECCIONE UN CABALLERO.");
	}
	public static void menuAdministrador() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(ADMINISTRAR_CABALLEROS + ". ADMINISTRAR CABALLEROS.");
		System.out.println(ADMINISTRAR_ESCUDOS + ". ADMINISTRAR ESCUDOS.");
		System.out.println(ADMINISTRAR_ARMAS + ". ADMINISTRAR ARMAS.");
		//System.out.println(ADMINISTRAR_CABALLOS+ ". ADMINISTRAR CABALLOS.");
		//System.out.println(ADMINISTRAR_ESCUDEROS + ". ADMINISTRAR ESCUDEROS.");
	}
	public static void menuCrudCaballero() {
		System.out.println(SALIR + ". SALIR.");
		
		System.out.println(VER_CABALLERO + ". VER CABALLEROS.");
		System.out.println(CREAR_CABALLERO + ". CREAR CABALLERO.");
		System.out.println(MODIFICAR_CABALLERO + ". MODIFICAR CABALLERO.");
		System.out.println(ELIMINAR_CABALLERO + ". ELIMINAR CABALLERO.");
	}
	public static void menuCrudEscudo() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(VER_ESCUDOS + ". VER ESCUDOS.");
		System.out.println(CREAR_ESCUDO + ". CREAR ESCUDO.");
		System.out.println(MODIFICAR_ESCUDO + ". MODIFICAR ESCUDO.");
		System.out.println(ELIMINAR_ESCUDO + ". ELIMINAR ESCUDO.");
	}
	public static void menuCrudCaballo() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(CREAR_CABALLO + ". CREAR CABALLO.");
		System.out.println(MODIFICAR_CABALLO + ". MODIFICAR CABALLO.");
		System.out.println(ELIMINAR_CABALLO + ". ELIMINAR CABALLO.");
	}
	public static void menuCrudArma() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(VER_ARMAS + ". VER ARMAS.");
		System.out.println(CREAR_ARMA + ". CREAR ARMA.");
		System.out.println(MODIFICAR_ARMA + ". MODIFICAR ARMA.");
		System.out.println(ELIMINAR_ARMA + ". ELIMINAR ARMA.");
	}
	public static void menuCrudEscudero() {
		System.out.println(SALIR + ". SALIR.");
		System.out.println(CREAR_ESCUDERO + ". CREAR ESCUDERO.");
		System.out.println(MODIFICAR_ESCUDERO + ". MODIFICAR ESCUDERO.");
		System.out.println(ELIMINAR_ESCUDERO + ". ELIMINAR ESCUDERO.");
	}
	
	
}
