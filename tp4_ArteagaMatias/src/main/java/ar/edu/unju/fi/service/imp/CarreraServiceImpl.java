package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService {
	
	@Autowired
	private CarreraMapper carreraMapper;
	
	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	public List<CarreraDTO> findAll() {
		List<Carrera> carreras = carreraRepository.findAll();
		List<CarreraDTO> carrerasDTO = carreraMapper.toCarreraDTOList(carreras);
		return carrerasDTO;
	}

	@Override
	public CarreraDTO findById(Integer codigo) {
		Optional<Carrera> carreraBuscada = carreraRepository.findById(codigo);
		return carreraBuscada.map(carreraMapper::toCarreraDTO).orElse(null);
	}

	@Override
	public void saveCarreraDTO(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carreraRepository.save(carrera);
	}

	@Override
	public void deleteByID(Integer codigo) {
		carreraRepository.deleteById(codigo);
	}

	@Override
	public void edit(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carreraRepository.save(carrera);
	}

}
