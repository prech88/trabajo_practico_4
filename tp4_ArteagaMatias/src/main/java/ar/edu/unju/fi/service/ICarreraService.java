package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {
	
	List<CarreraDTO> findAll();
	
	CarreraDTO findById(Integer codigo);
	
	void saveCarreraDTO (CarreraDTO carreraDTO);
	
	void deleteByID(Integer codigo);
	
	void edit(CarreraDTO carreraDTO);

}
