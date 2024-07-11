package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {
	
	List<MateriaDTO> findAll();
	
	MateriaDTO findById(Integer codigo);
	
	void saveMateriaDTO (MateriaDTO materiaDTO);
	
	void deleteByID(Integer codigo);
	
	void edit(MateriaDTO materiaDTO);
	
}