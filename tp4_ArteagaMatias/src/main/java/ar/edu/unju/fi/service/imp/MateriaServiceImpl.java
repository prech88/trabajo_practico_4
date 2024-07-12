package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;
@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private MateriaMapper materiaMapper;
	
	@Autowired
	private MateriaRepository materiaRepository;

	@Override
	public List<MateriaDTO> findAll() {
		List<Materia> materias = materiaRepository.findAll();
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriasDTO(materias);
		return materiasDTO;
	}
	
	@Override
	public List<MateriaDTO> findByCarreraId(Integer codigoCarrera) {
	    List<Materia> materias = materiaRepository.findAll();
	    List<MateriaDTO> materiasDTO = new ArrayList<>();

	    for (Materia materia : materias) {
	        if (materia.getCarrera().getCodigo().equals(codigoCarrera)) {
	            materiasDTO.add(materiaMapper.toMateriaDTO(materia));
	        }
	    }

	    return materiasDTO;
	}


	@Override
	public MateriaDTO findById(Integer codigo) {
		Optional<Materia> materiaBuscada = materiaRepository.findById(codigo);
		return materiaBuscada.map(materiaMapper::toMateriaDTO).orElse(null);
	}

	@Override
	public void saveMateriaDTO(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.toMateria(materiaDTO);
		materiaRepository.save(materia);
	}

	@Override
	public void deleteByID(Integer codigo) {
		materiaRepository.deleteById(codigo);
	}

	@Override
	public void edit(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.toMateria(materiaDTO);
		materiaRepository.save(materia);
	}
	
	public void eliminarMateriasDeCarrera(Integer carreraCodigo) {
	    List<Materia> materias = materiaRepository.findAll();
	    List<Materia> materiasDeCarrera = materias.stream()
	        .filter(materia -> materia.getCarrera() != null && materia.getCarrera().getCodigo().equals(carreraCodigo))
	        .collect(Collectors.toList());
	    for (Materia materia : materiasDeCarrera) {
	        materiaRepository.delete(materia);
	    }
	}

}
