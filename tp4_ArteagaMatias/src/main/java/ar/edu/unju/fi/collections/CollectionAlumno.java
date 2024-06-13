package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static void cargarAlumnos(List<Alumno> alumnos) {
		alumnos.add(new Alumno(35246891, "Pedro", "Juarez", "pedr56@gmail.com", (long)388424035, LocalDate.of(1995, 6, 15), "Calle Barrientos 123", 3245));
		alumnos.add(new Alumno(36254982, "Pepe", "Ibañez", "pepe32@gmail.com", (long)388457469, LocalDate.of(1995, 7, 26), "Calle Coronel Arias 321", 2654));
		alumnos.add(new Alumno(37324951, "Oracio", "Castellon", "ora54@gmail.com", (long)388485429, LocalDate.of(1995, 8, 30), "Calle Los Lapachos 456", 4123));
	}
	
	public static List<Alumno> getAlumnos() {
		if (alumnos.isEmpty()) {
			cargarAlumnos(alumnos);
		}
		return alumnos;
	}
	
	public static void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	public static void elminarAlumno(int dniAlumno) {
		Iterator<Alumno> iterator = alumnos.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getDni() == dniAlumno) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarAlumno(Alumno alumno) {
		int dni = alumno.getDni();
		for (Alumno alu : alumnos) {
			if (alu.getDni() == dni) {
				alu.setNombre(alumno.getNombre());
				alu.setApellido(alumno.getApellido());
				alu.setEmail(alumno.getEmail());
				alu.setTelefono(alumno.getTelefono());
				alu.setDomicilio(alumno.getDomicilio());
				alu.setLu(alumno.getLu());
			}
		}
	}
	
	public static Alumno buscarAlumno(int dniAlumno) {
		Predicate<Alumno> filterDni = a -> a.getDni() == dniAlumno;
		Optional<Alumno> alumno = alumnos.stream().filter(filterDni).findFirst();
        if (alumno.isPresent()) {
            return alumno.get();
        } else {
            return null;
        }
	}

}