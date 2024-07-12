package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService {
	
	private static final Log LOGGER = LogFactory.getLog(CarreraServiceImpl.class);
	
	@Autowired
	private CarreraMapper carreraMapper;
	
	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	public List<CarreraDTO> findAll() {
		List<Carrera> carreras = carreraRepository.findAll();
		List<CarreraDTO> carrerasDTO = carreraMapper.toCarreraDTOList(carreras);
		LOGGER.info("Se solicita el listado de carreras de la lista: " + carreras.size());
		return carrerasDTO;
	}

	@Override
	public CarreraDTO findById(Integer codigo) {
		Optional<Carrera> carreraBuscada = carreraRepository.findById(codigo);
		if (carreraBuscada.isEmpty()) {
			LOGGER.error("No se ha encontrado una carrera en la base de datos");
		}else {
			LOGGER.info("Se ha encontrado carrera con el codigo: " + codigo);;
		}
		return carreraBuscada.map(carreraMapper::toCarreraDTO).orElse(null);
	}

	@Override
	public void saveCarreraDTO(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carreraRepository.save(carrera);
		LOGGER.info("Se guarda exitosamente la nueva carrera");
	}

	@Override
	public void deleteByID(Integer codigo) {
		carreraRepository.deleteById(codigo);
		LOGGER.info("Se ha eliminado una carrera con el codigo: " + codigo);
	}

	@Override
	public void edit(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carreraRepository.save(carrera);
		LOGGER.info("Se modifica la carrera con el codigo nuemero: " + carrera.getCodigo());
	}

}
