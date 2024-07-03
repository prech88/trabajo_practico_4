package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService{
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<AlumnoDTO> findAll() {
		List<Alumno> alumnos = alumnoRepository.findAll();
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnos);
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO findById(Integer dni) {
		Optional<Alumno> alumnoBuscado = alumnoRepository.findById(dni);
		return alumnoBuscado.map(alumnoMapper::toAlumnoDTO).orElse(null);
	}

	@Override
	public void saveAlumnoDTO(AlumnoDTO alumnoDTO) {
		Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
	}

	@Override
	public void deleteByID(Integer dni) {
		alumnoRepository.deleteById(dni);
	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) {
		Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
	}

}
