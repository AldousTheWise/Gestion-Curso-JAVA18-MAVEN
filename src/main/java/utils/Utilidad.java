package utils;

import vistas.MenuTemplate;

public class Utilidad {
	public static void limpiarPantalla(int lineas) {
		for (int i = 0; i < lineas; i++) {
			System.out.println();
		}
	}
	
	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void mostrarMensajePausado(String mensaje) {
		for (char c : mensaje.toCharArray()) {
			System.out.print(c);
			
		    try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		
	}
	
	public static void limpiarPantallaYRegresar(MenuTemplate menu) {
		limpiarPantalla(10);
		System.out.println("Regresando al menu principal");
		System.out.println("----------------------------");
		menu.iniciarMenu();
	}

}
