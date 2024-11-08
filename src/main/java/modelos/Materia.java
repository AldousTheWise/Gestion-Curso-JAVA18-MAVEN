package modelos;

import java.util.*;
/**
 * Clase materia, con atributos
 * @param nombre tipo Materia Enum
 * @param notas tipo List.
 * Getters y Setters
 * 
 */

public class Materia {
	private MateriaEnum nombre;
	private List<Double> notas;
	
	public Materia(MateriaEnum nombre) {
		this.nombre = nombre;
		this.notas = new ArrayList<>();
	}

	public MateriaEnum getNombre() { return nombre; }
	public List<Double> getNotas() { return notas; }

	public void setNombre(MateriaEnum nombre) { this.nombre = nombre; }
	public void setNotas(List<Double> notas) { this.notas = notas; }
	
}
