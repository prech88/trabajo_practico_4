package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	public static void cargarCarreras(List<Carrera> carreras) {
		carreras.add(new Carrera(1, "Analista Programador Univversitario", (byte)3, true));
		carreras.add(new Carrera(2, "Analista de sistemas", (byte)5, true));
		carreras.add(new Carrera(2, "Programacion en video juegos", (byte)5, false));
	}
	
	public static List<Carrera> getCarreras() {
		if (carreras.isEmpty()) {
			cargarCarreras(carreras);
		}
		return carreras;
	}
	
	public static void agregarCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	
	public static void elminarCarrera(int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCodigo() == codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarCarrera(Carrera carrera) {
		for (Carrera carre : carreras) {
			if (carre.getCodigo() == carrera.getCodigo()) {
				carre.setCantAños(carrera.getCantAños());
				carre.setEstado(carrera.getEstado());
				carre.setNombre(carrera.getNombre());
			}
		}
	}
	
	public static Carrera buscarCarrera(int codCarrera) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codCarrera;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
        if (carrera.isPresent()) {
            return carrera.get();
        } else {
            return null;
        }
	}

}