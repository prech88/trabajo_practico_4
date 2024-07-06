package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CarreraMapper.class, DocenteMapper.class})
@Component
public interface MateriaMapper {
	
	MateriaDTO toMateriaDTO(Materia materia);
	
	@InheritInverseConfiguration
	Materia toMateria(MateriaDTO materiaDTO);
	
	List<MateriaDTO> toMateriasDTO(List<Materia> materias);
	
	List<Materia> toMaterias(List<MateriaDTO> materiasDTO);
	
}
