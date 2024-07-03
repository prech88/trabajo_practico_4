package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface AlumnoMapper {
	
	AlumnoDTO toAlumnoDTO(Alumno alumno);
	
	@InheritInverseConfiguration
	Alumno toAlumno(AlumnoDTO alumnoDTO);
	
	List<AlumnoDTO> toAlumnoDTOList(List<Alumno> alumnos);
	
	List<Alumno> toAlumnoList(List<AlumnoDTO> alumnosDTO);
	
}
