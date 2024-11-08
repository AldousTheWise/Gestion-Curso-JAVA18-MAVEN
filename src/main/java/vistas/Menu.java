package vistas;

import java.io.IOException;
import java.util.*;

import modelos.*;
import servicios.*;
import utils.Utilidad;

public class Menu extends MenuTemplate {
	/**
	 * 2. Clase Menu que hereda de la clase abstracta Menu template:
	 * @param alumnoServicio, instancia de AlumnoServicio.
	 * @param archivoServicio, instancia de ArchivoServicio que
	 * recibe como @param promedioServicio, instancia de
	 * PromedioServicioImp.
	 */
	Scanner sc = new Scanner(System.in);
	
	PromedioServicioImp promedioServicio = new PromedioServicioImp();
	private AlumnoServicio alumnoServicio = new AlumnoServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio(promedioServicio);

	/**
	 * exportarDatos es la sobrescritura del metodo abstracto definido
	 * en MenuTemplate.
	 * Contiene la lógica para exportar los datos a un txt, la cual está
	 * contenida en ArchivoServicio.
	 */
	@Override
	public void exportarDatos() {
		Utilidad.mostrarMensaje("--- Exportar datos ---");
		Utilidad.mostrarMensaje("Ingrese la ruta del archivo notas.txt :");
		String ruta = sc.nextLine();
	   	archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);	
	   	Utilidad.mostrarMensajePausado("Datos exportados correctamente.");
	   	Utilidad.limpiarPantallaYRegresar(this);
	}
	
	/**
	 * crearAlumno pide a través de Scanner los datos para crear un 
	 * nuevo objeto Alumno con los atributos correspondientes.
	 */
	@Override
	public void crearAlumno() {
		Utilidad.mostrarMensaje("--- Crear Alumno ---");
		Utilidad.mostrarMensaje("Ingresa Rut:");
		String rut = sc.nextLine();
		Utilidad.mostrarMensaje("Ingresa nombre:");
		String nombre = sc.nextLine();
		Utilidad.mostrarMensaje("Ingresa apellido:");
		String apellido = sc.nextLine();
		Utilidad.mostrarMensaje("Ingresa direccion: ");
		String direccion = sc.nextLine();
		
		Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion);
		alumnoServicio.crearAlumno(nuevoAlumno);
		Utilidad.mostrarMensajePausado("--- ¡Alumno agregado! --- ");
		Utilidad.limpiarPantallaYRegresar(this);
		
	}
    
	/**
	 * listarAlumnos contiene la lógica para mostrar por consola
	 * los alumnos registrados dentro del Map alumnos.
	 */
	@Override
	public void listarAlumnos() {
		Utilidad.mostrarMensaje( "--- Listar alumnos ---");
		Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
		PromedioServicioImp promedioServicio = new PromedioServicioImp();
		
		
		if (alumnos.isEmpty()) {
			Utilidad.mostrarMensaje("No hay alumnos registrados.");
		} else {
			
			for (Alumno alumno : alumnos.values()) {
				String datos = "Rut:" + alumno.getRut() + "\n" +
			                   "Nombre: " + alumno.getNombre() + "\n" +
						       "Apellido: " + alumno.getApellido() + "\n" +
			                   "Dirección: " + alumno.getDireccion();
				
				Utilidad.mostrarMensaje(datos);
				
				if (alumno.getMaterias().isEmpty()) {
					
					Utilidad.mostrarMensaje("El alumno no tiene materias asignadas.");
					
				} else {
					
					for (Materia materia : alumno.getMaterias()) {
						Utilidad.mostrarMensaje("Materia: " + materia.getNombre());
						
						if(materia.getNotas().isEmpty()) {
							
							Utilidad.mostrarMensaje("No hay notas registradas.");
							
						} else {
							
							System.out.println("Notas: ");
							
							for (Double nota: materia.getNotas()) {
								Utilidad.mostrarMensaje(nota + " ");
							}
							
                            double promedio = promedioServicio.calcularPromedio(materia.getNotas());
                            System.out.printf("  Promedio: %.1f%n", promedio);  
						}
				     }  
				  }
			   } 
			}
		Utilidad.mostrarMensaje("\n Presiona Enter para continuar...");
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Utilidad.limpiarPantallaYRegresar(this);
	}
    
	
	/**
	 * agregarMateria agrega items materias dentro del ArrayList contenido 
	 * en el objeto Alumno, se especifica la búsqueda del alumno al
	 * que adosarle los datos a través del RUT, como llave primaria.
	 */
	@Override
	public void agregarMateria() {
		Utilidad.mostrarMensaje("--- Agregar Materia ---");
		Utilidad.mostrarMensaje("Ingresa el rut del alumno: ");
		String rut = sc.nextLine();
		
		Utilidad.mostrarMensaje("Seleccione materia:");
		for (int i = 0; i < MateriaEnum.values().length; i++) {
			Utilidad.mostrarMensaje(i + 1 + ". " + MateriaEnum.values()[i]);
		}
		
		int opcion = sc.nextInt();
		sc.nextLine();
		MateriaEnum materiaSeleccionada = MateriaEnum.values()[opcion -1];
		
		Materia nuevaMateria = new Materia(materiaSeleccionada);
		alumnoServicio.agregarMateria(rut, nuevaMateria);
		
		Utilidad.mostrarMensajePausado(" --- Materia agregada --- ");
		Utilidad.limpiarPantallaYRegresar(this);
	}

	
	/**
	 * agregarNota contiene la lógica 
	 * para agregar notas a la Lista Materias.
	 * Selecciona el alumno en particular para ver que materias tiene,
	 * y agrega la nota correspondiente.
	 */
	@Override
	public void agregarNota() {
		Utilidad.mostrarMensaje("--- Agregar nota ---");
		Utilidad.mostrarMensaje("Ingresa el rut del alumno: ");
		String rut = sc.nextLine();
		
		List<Materia> materias = alumnoServicio.materiasPorAlumno(rut);
	    if(materias.isEmpty()) {
	    	Utilidad.mostrarMensaje("El alumno no tiene materias asignadas.");
	    	return;
	     }
	    
	    /**
	     * Acá se despliegan las materias ya ingresadas en el objeto
	     * Alumno, pudiendo seleccionar una para proceder a agregar 
	     * nota.
	     */
	    Utilidad.mostrarMensaje("Alumno tiene las siguientes materias agregadas:");
	    
	    for (int i = 0; i < materias.size(); i++) {
			Utilidad.mostrarMensaje(i + 1 + ". " + materias.get(i).getNombre() + ".");
		}
	    
	    Utilidad.mostrarMensaje("Seleccione una materia: ");
	    int opcion = sc.nextInt();
	    sc.nextLine();
	    Materia materiaSeleccionada = materias.get(opcion - 1);
	    
	    /**
	     * @param notaValida es la variable que valida lo ingresado por
	     * el usuario.
	     * @param nota inicializa la variable.
	     * @param notaStr captura en un string la nota para reemplazar
	     * la coma por un punto y no tener fallos en el procesamiento
	     * de la variable tipo double.
	     * @param nota procesa el dato extraído desde notaStr, parseandolo
	     * a tipo double.
	     */
	    
	    boolean notaValida = false;
	    
	    double nota = 0.0;
	    
	    while(!notaValida) {
	    	Utilidad.mostrarMensaje("Ingresar nota:");
	    	String notaStr = sc.nextLine().replace(",", ".");
	    	try {
				nota = Double.parseDouble(notaStr);
				notaValida = true;
			} catch (InputMismatchException e) {
				Utilidad.mostrarMensaje("Por favor, ingrese un numero válido.");
				sc.nextLine();
			}    		    	
	    }
	   
	    
	    materiaSeleccionada.getNotas().add(nota);
	    
	    Utilidad.mostrarMensajePausado(" --- Nota agregada a " + materiaSeleccionada.getNombre() + " --- ");
	    Utilidad.limpiarPantallaYRegresar(this);
	}
    /**
     * terminarPrograma muestra un mensaje, cierra el Scanner,
     * limpia la pantalla y termina el proceso del sistema.
     */
	@Override
	public void terminarPrograma() {
		Utilidad.mostrarMensajePausado("Gracias por usar el sistema. Hasta Pronto!");
		
		if (sc != null) {  sc.close(); }
		Utilidad.limpiarPantalla(20);
		System.exit(0);	
	}

}
