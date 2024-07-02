package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface DocenteMapper {

	DocenteDto toDocenteDto(Docente docente);
	
	@InheritInverseConfiguration
	Docente toDocente(DocenteDto docenteDto);
	
	List<DocenteDto> toDocenteDtoList(List<Docente> docente);
	
	List<Docente> toDocenteList(List<DocenteDto> docentesDto);
}
