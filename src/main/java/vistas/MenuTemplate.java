/**
 * 1. Crear clase MenuTemplate en carpeta vistas.
 */


package vistas;

import java.util.Scanner;

import utils.Utilidad;

public abstract class MenuTemplate {
	
	/**
	 * @params sc: implementa Scanner para recibir datos de consola.
	 */
	protected Scanner sc = new Scanner(System.in);
	
	/**
	 * Métodos abstractos a implementar:
	 */
	public abstract void crearAlumno();
	public abstract void listarAlumnos();
	public abstract void agregarMateria();
	public abstract void agregarNota();
	public abstract void terminarPrograma();
	public abstract void exportarDatos();
	
	/**
	 * Método iniciarMenu que recibe la opción ingresada por el usuario
	 * desde el scanner.
	 * @param continuar es la variable de tipo boolean que condiciona el 
	 * ciclo while del menú.
	 */
	
	public final void iniciarMenu() {
		boolean continuar = true;	
		while (continuar) {
			
			String menu = "Menú Principal: \n" +
					"1. Crear alumno. \n" +
					"2. Agregar Materias. \n"+
					"3. Agregar Notas. \n"+
					"4. Listar Alumnos. \n"+
					"5. Exportar datos. \n"+
					"6. Salir. \n"+
					"Elige una opcion:";
			
			Utilidad.mostrarMensaje(menu);
			
			int opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1:
				crearAlumno();
				break;
			case 2:
				agregarMateria();	
				break;
			case 3:
				agregarNota();
				break;
			case 4:
				listarAlumnos();	
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				terminarPrograma();	
				continuar = false;
				break;
			default:
				Utilidad.mostrarMensaje("Opción no válida.");	
				break;
		    }
				
		}			
	}   
}
