package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {
	
	List<CarreraDTO> findAll();
	
	CarreraDTO findByCodigo(int codigo);
	
	boolean save(CarreraDTO carreraDTO);
	
	void deleteByCodigo(int codigo);
	
	void edit(CarreraDTO carreraDTO);
}
