package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;

@Component
public class CollectionMateria {
	
private static List<Materia> materias = new ArrayList<Materia>();
	
	public static List<Materia> getMaterias() {
		if (materias.isEmpty()) {
			return null;
		}
		return materias;
	}
	
	public static void agregarMateria(Materia materia) {
		materias.add(materia);
	}
	
	public static void elminarMateria(int codigo) {
		Iterator<Materia> iterator = materias.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCodigoMateria() == codigo) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarMateria(Materia materia) {
		for (Materia mat : materias) {
			if (mat.getCodigoMateria() == materia.getCodigoMateria()) {
				mat.setNombre(materia.getNombre());
				mat.setCurso(materia.getCurso());
				mat.setCantHoras(materia.getCantHoras());
				mat.setModalidad(materia.getModalidad());
				mat.setDocente(materia.getDocente());
				mat.setCarrera(materia.getCarrera());
			}
		}
	}
	
	public static Materia buscarMateria(int codigo) {
		Predicate<Materia> filterCodigo = m -> m.getCodigoMateria() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
        if (materia.isPresent()) {
            return materia.get();
        } else {
            return null;
        }
	}

}