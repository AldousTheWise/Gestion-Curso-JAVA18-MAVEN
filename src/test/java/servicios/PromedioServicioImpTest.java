package servicios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class PromedioServicioImpTest {

	@Test
	public void calcularPromedioTest() {
		PromedioServicioImp promedioServicio = new PromedioServicioImp();
		
		List<Double> notas = Arrays.asList(3.5, 4.0, 5.0);
		
		double promedioEsperado = 4.17;
		
		double promedioCalculado = promedioServicio.calcularPromedio(notas);
		
		assertEquals(promedioEsperado, promedioCalculado, 0.01);
	}
	
}

