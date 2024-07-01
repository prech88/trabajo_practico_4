package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.service.IDocenteService;
@Service
public class DocenteServicelmp implements IDocenteService {
	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public List<DocenteDto> findAll() {
		List<DocenteDto> docenteDto = docenteMapper.toDocenteDtoList(CollectionDocente.getDocentes());
		return docenteDto;
	}

	@Override
	public DocenteDto findById(Integer codigo) {
		DocenteDto docenteDto = docenteMapper.toDocenteDto(CollectionDocente.buscarDocente(codigo));
		return docenteDto;
	}

	@Override
	public void saveDocenteDto (DocenteDto docenteDto) {
		CollectionDocente.agregarDocente(docenteMapper.toDocente(docenteDto));
	}

	@Override
	public void deleteByID(Integer codigo) {
		CollectionDocente.elminarDocente(codigo);
	}

	@Override
	public void edit(DocenteDto docenteDto) {
		CollectionDocente.modificarDocente(docenteMapper.toDocente(docenteDto));
	}

}
