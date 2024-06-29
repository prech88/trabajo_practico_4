package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface CarreraMapper {
	
	CarreraDTO toCarreraDTO(Carrera carrera);
	
	@InheritInverseConfiguration
	Carrera toCarrera(CarreraDTO carreraDTO);
	
	List<CarreraDTO> toCarreraDTOList(List<Carrera> carreras);
	
	List<Carrera> toCarreraList(List<CarreraDTO> carrerasDTO);
	
}