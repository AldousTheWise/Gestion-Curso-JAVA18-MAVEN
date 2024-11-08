package servicios;

import java.util.*;
import modelos.*;

/**
 * El service AlumnoServicio contiene la lógica
 * para poder llenar el Map lista Alumnos 
 * con sus keys y sus atributos.
 */

public class AlumnoServicio {
	private Map<String,  Alumno> listaAlumnos = new HashMap<>();
    
	public void crearAlumno(Alumno alumno) {
		listaAlumnos.put(alumno.getRut(), alumno);
	}
	
	/**
	 * En el método agregarMateria
	 * @param rutAlumno determina a que alumno vamos a ingresarle datos.
	 * @param materia determina que materias van a ser agregadas al alumno.
	 */
	public void agregarMateria(String rutAlumno, Materia materia) {
		Alumno alumno = listaAlumnos.get(rutAlumno);
		if (alumno != null) { alumno.getMaterias().add(materia); }
	}
	
	public List<Materia> materiasPorAlumno(String rutAlumno) {
		Alumno alumno = listaAlumnos.get(rutAlumno);
		if (alumno != null) {
			return alumno.getMaterias();
		} else {
			return new ArrayList<>();
		}
	}
	
	public Map<String, Alumno> listarAlumnos() { return listaAlumnos; }
}
