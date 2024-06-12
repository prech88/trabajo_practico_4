package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {

	private static List<Docente> docentes = new ArrayList<Docente>();
	
	public static void cargarDocentes(List<Docente> docentes) {
		docentes.add(new Docente(1526, "Marcelo", "Perez", (long)388425168));
		docentes.add(new Docente(1432, "Ariel", "Vega", (long)388458746));
		docentes.add(new Docente(1365, "Juan", "Rodriguez", (long)388498524));
	}
	
	public static List<Docente> getDocentes() {
		if (docentes.isEmpty()) {
			cargarDocentes(docentes);
		}
		return docentes;
	}
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	public static void elminarDocente(int legajo) {
		Iterator<Docente> iterator = docentes.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getLegajo() == legajo) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarDocente(Docente docente) {
		for (Docente doc : docentes) {
			if (doc.getLegajo() == docente.getLegajo()) {
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setTelefono(docente.getTelefono());
			}
		}
	}
	
	public static Docente buscarDocente(int legajo) {
		Predicate<Docente> filterLegajo = d -> d.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
        if (docente.isPresent()) {
            return docente.get();
        } else {
            return null;
        }
	}

}