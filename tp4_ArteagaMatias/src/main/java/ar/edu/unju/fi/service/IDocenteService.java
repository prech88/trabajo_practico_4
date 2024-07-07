package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.DocenteDto;

public interface IDocenteService {
List<DocenteDto> findAll();
	
	DocenteDto findById(Integer codigo);
	
	void saveDocenteDto (DocenteDto docenteDto);
	
	void deleteByID(Integer codigo);
	
	void edit(DocenteDto DocenteDto);
	
    boolean tieneMateriasAsignadas(Integer legajo);

}
