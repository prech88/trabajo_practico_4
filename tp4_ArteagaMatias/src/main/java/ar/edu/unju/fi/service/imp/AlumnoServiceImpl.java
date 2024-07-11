package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService{
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;

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

	@Override
	public void inscribirAlumno(Integer alumnoId, Integer materiaId) {
	   
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(alumnoId);
        Optional<Materia> optionalMateria = materiaRepository.findById(materiaId);

        if (optionalAlumno.isEmpty()) {
            throw new RuntimeException("Alumno no encontrado con ID: " + alumnoId);
        }

        if (optionalMateria.isEmpty()) {
            throw new RuntimeException("Materia no encontrada con ID: " + materiaId);
        }

        Alumno alumno = optionalAlumno.get();
        Materia materia = optionalMateria.get();

        if (alumno.getMaterias().contains(materia)) {
            throw new RuntimeException("El alumno ya está inscrito en la materia.");
        }

        alumno.getMaterias().add(materia);
        alumnoRepository.save(alumno);
		
	}

	@Override
	public List<AlumnoDTO> findByMateriaId(Integer materiaId) {
	    List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .filter(alumno -> alumno.getMaterias().stream()
                        .anyMatch(materia -> materia.getCodigoMateria().equals(materiaId)))
                .map(alumnoMapper::toAlumnoDTO)
                .collect(Collectors.toList());
    }
	
}



