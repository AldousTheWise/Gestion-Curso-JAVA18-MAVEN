package servicios;

import java.io.*;

import java.util.*;

import modelos.*;

/**
 * En esta clase se implementa la lógica para exportar los datos a un archivo.txt
 */

public class ArchivoServicio {
	private PromedioServicioImp promedioServicio;
	
	public ArchivoServicio(PromedioServicioImp promedioServicio) {
		this.promedioServicio = promedioServicio;
	}
	
	
	public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
	 
		File directorio = new File("target/archivos_exportados");
		if(!directorio.exists()) {
			directorio.mkdirs();
		}
		
		File archivo = new File(ruta);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))){
			for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
				Alumno alumno = entry.getValue();
				
				writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido() + ". \n");
				
				writer.write("Materias [\n");
				for (Materia materia : alumno.getMaterias()) {
					writer.write(" " + materia.getNombre() + ", notas [");
					
					List<Double> notas = materia.getNotas();
					for (int i = 0; i < notas.size(); i++) {
						writer.write(String.format("%.1f", notas.get(i)));
						
						if(i < notas.size() - 1) {
							writer.write(", ");
						}
					}
					writer.write("]\n");
				}
				
				writer.write("]\n");
				
				writer.write("Materia: ");
				
				for (Materia materia : alumno.getMaterias()) {
					double promedio = promedioServicio.calcularPromedio(materia.getNotas());
					writer.write(materia.getNombre() +" - promedio: " + String.format("%.1f", promedio) + ", ");
				}
				
				writer.write("\n\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
}
