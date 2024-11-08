package servicios;

import modelos.*;


import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AlumnoServicioTest {
	
	private AlumnoServicio alumnoServicio;
	
	@Mock
	private AlumnoServicio alumnoServicioMock;
	
	private Materia matematicas;
	private Materia lenguaje;
	private Alumno mapu;
	
	@BeforeEach
	
	public void setup() {
		MockitoAnnotations.openMocks(this);
		alumnoServicio = new AlumnoServicio();
		
		matematicas = new Materia(MateriaEnum.MATEMATICAS);
		lenguaje = new Materia(MateriaEnum.LENGUAJE);
		mapu = new Alumno("12.345.678-9", "Mapu", "Pérez", "Calle Falsa 123");		
	}
	
	@Test 
	public void crearAlumnoTest() {
		alumnoServicio.crearAlumno(mapu);
		
		Map<String, Alumno> listaAlumnos = alumnoServicio.listarAlumnos();
		assertEquals(1, listaAlumnos.size());
		assertEquals(mapu, listaAlumnos.get("12.345.678-9"));
	}
	
	@Test
	public void agregarMateriaTest() {
		alumnoServicio.crearAlumno(mapu);
		alumnoServicio.agregarMateria("12.345.678-9", matematicas);
	
		List<Materia> materias =  alumnoServicio.materiasPorAlumno("12.345.678-9");
		assertEquals(1, materias.size());
		assertEquals(matematicas, materias.get(0));
	}
	
	@Test
	public void materiasPorAlumnoTest() {
		when(alumnoServicioMock.materiasPorAlumno("12.345.678-9")).
		thenReturn(new ArrayList<>(List.of(matematicas,lenguaje)));
		
		List<Materia> materias = alumnoServicioMock.materiasPorAlumno("12.345.678-9");
	    	
		assertEquals(2, materias.size());
		verify(alumnoServicioMock, times(1)).materiasPorAlumno("12.345.678-9");	
	}
	
	@Test
	public void listarAlumnosTest() {
		alumnoServicio.crearAlumno(mapu);
		
		Map<String, Alumno> listaAlumnos = alumnoServicio.listarAlumnos();
		
		assertEquals(1, listaAlumnos.size());
		assertEquals("Mapu", listaAlumnos.get("12.345.678-9").getNombre());
	}
}
