package servicios;

import java.util.List;

/**
 * Esta clase tiene la responsabilidad de hacer el 
 * cálculo del promedio de notas.
 */

public class PromedioServicioImp {
       
	public double calcularPromedio(List<Double> notas) {
		if (notas == null || notas.isEmpty()) {
			return 0.0;
		}
		
		double suma = 0.0;
		for (Double nota : notas) {
			suma += nota;
		}
		
		return suma/notas.size();
	}
}
