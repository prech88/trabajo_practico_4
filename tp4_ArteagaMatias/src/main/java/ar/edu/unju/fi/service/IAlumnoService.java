package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {
	
	List<AlumnoDTO> findAll();
	
	List<AlumnoDTO> findByMateriaId(Integer materiaId);
	
    AlumnoDTO findById(Integer dni);
	
	void saveAlumnoDTO (AlumnoDTO alumnoDTO);
	
	void deleteByID(Integer dni);
	
	void edit(AlumnoDTO alumnoDTO);
	
	void inscribirAlumno(Integer alumnoId, Integer materiaId);
	

}
