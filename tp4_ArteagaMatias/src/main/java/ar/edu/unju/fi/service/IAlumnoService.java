package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {
	
	List<AlumnoDTO> findAll();
	
    AlumnoDTO findById(Integer dni);
	
	void saveAlumnoDTO (AlumnoDTO alumnoDTO);
	
	void deleteByID(Integer dni);
	
	void edit(AlumnoDTO alumnoDTO);

}
