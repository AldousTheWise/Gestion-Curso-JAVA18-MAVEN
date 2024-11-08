/**
 * Sistema de gestion de notas de alumnos.
 * @author Aldo Yañez
 * @version 1.0
 */
package modelos;

import vistas.Menu;

public class Main {
	public static void main(String[] args) {
	/**
	 * Se importa la clase menu para ocupar su metodo iniciarMenu()
	 * que despliega el esquema de menu herededado de MenuTemplate.
	 */
		Menu menu = new Menu();
		menu.iniciarMenu();

	}

}
