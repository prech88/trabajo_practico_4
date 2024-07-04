package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;
@Service
public class DocenteServicelmp implements IDocenteService {
	@Autowired
	private DocenteMapper docenteMapper;
	@Autowired
	private DocenteRepository docenteRepository;
	@Override
	public List<DocenteDto> findAll() {
		List<Docente> docentes = docenteRepository.findAll();
		List<DocenteDto> docentesDto = docenteMapper.toDocenteDtoList(docentes);
		return docentesDto;
	}

	@Override
	public DocenteDto findById(Integer codigo) {
		Optional<Docente> docenteBuscado = docenteRepository.findById(codigo);
		return docenteBuscado.map(docenteMapper::toDocenteDto).orElse(null);
	}

	@Override
	public void saveDocenteDto (DocenteDto docenteDto) {
		Docente docente = docenteMapper.toDocente(docenteDto);
		docenteRepository.save(docente);
	}

	@Override
	public void deleteByID(Integer codigo) {
		docenteRepository.deleteById(codigo);
	}

	@Override
	public void edit(DocenteDto docenteDto) {
		Docente docente = docenteMapper.toDocente(docenteDto);
		docenteRepository.save(docente);
	}

}

