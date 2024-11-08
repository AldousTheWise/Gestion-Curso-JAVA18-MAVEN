package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Alumno, con constructor, getters and setters.
 */
public class Alumno {
    private String rut, nombre, apellido, direccion;
    private List<Materia> materias;
    
	public Alumno(String rut, String nombre, String apellido, String direccion) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.materias = new ArrayList<>();
	}
	
	
	public String getRut() { return rut; }
	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public String getDireccion() { return direccion; }
	public List<Materia> getMaterias() { return materias; }
	
	public void setRut(String rut) { this.rut = rut; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	public void setMaterias(List<Materia> materias) { this.materias = materias; }
    
    
    
}
