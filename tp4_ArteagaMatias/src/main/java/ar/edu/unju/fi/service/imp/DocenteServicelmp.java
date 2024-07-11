package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;

@Service
public class DocenteServicelmp implements IDocenteService {
	
	private static final Log LOGGER = LogFactory.getLog(DocenteServicelmp.class);
	
	@Autowired
	private MateriaServiceImpl materiaService;
	@Autowired
	private DocenteMapper docenteMapper;
	@Autowired
	private DocenteRepository docenteRepository;

	@Override
	public List<DocenteDto> findAll() {
		List<Docente> docentes = docenteRepository.findAll();
		List<DocenteDto> docentesDto = docenteMapper.toDocenteDtoList(docentes);
		LOGGER.info("Se solicita el listado de docentes. Tamaño de la lista: " + docentes.size());
		return docentesDto;
	}

	@Override
	public DocenteDto findById(Integer codigo) {
		Optional<Docente> docenteBuscado = docenteRepository.findById(codigo);
		if (docenteBuscado.isEmpty()) {
			LOGGER.error("No se ha encontrado a un docente en la base de datos");
		}else {
			LOGGER.info("Se ha encontrado docente con el codigo: " + codigo);;
		}
		return docenteBuscado.map(docenteMapper::toDocenteDto).orElse(null);
	}

	@Override
	public void saveDocenteDto(DocenteDto docenteDto) {
		Docente docente = docenteMapper.toDocente(docenteDto);
		docenteRepository.save(docente);
		LOGGER.info("Se guarda exitosamente el nuevo docente");
	}

	@Override
	public void deleteByID(Integer codigo) {
		docenteRepository.deleteById(codigo);
		LOGGER.info("Se ha eliminado un docente con el codigo: " + codigo);
	}

	@Override
	public void edit(DocenteDto docenteDto) {
		Docente docente = docenteMapper.toDocente(docenteDto);
		docenteRepository.save(docente);
		LOGGER.info("Se modifica el docente con el legajo nuemero: " + docente.getLegajo());
	}

	@Override
	public boolean tieneMateriasAsignadas(Integer legajo) {
		LOGGER.info("se verifica si el docente con legajo: " + legajo + " corresponde a una materia");
		return materiaService.findAll().stream().anyMatch(materia -> materia.getDocente().getLegajo().equals(legajo));
	}

}
