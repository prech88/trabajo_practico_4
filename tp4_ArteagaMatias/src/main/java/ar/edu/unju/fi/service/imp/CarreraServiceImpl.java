package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService {
	
	@Autowired
	private CarreraMapper carreraMapper;

	@Override
	public List<CarreraDTO> findAll() {
		List<CarreraDTO> carrerasDTO = carreraMapper.toCarreraDTOList(CollectionCarrera.getCarreras());
		return carrerasDTO;
	}

	@Override
	public CarreraDTO findById(Integer codigo) {
		CarreraDTO carreraDTO = carreraMapper.toCarreraDTO(CollectionCarrera.buscarCarrera(codigo));
		return carreraDTO;
	}

	@Override
	public void saveCarreraDTO(CarreraDTO carreraDTO) {
		CollectionCarrera.agregarCarrera(carreraMapper.toCarrera(carreraDTO));
	}

	@Override
	public void deleteByID(Integer codigo) {
		CollectionCarrera.elminarCarrera(codigo);
	}

	@Override
	public void edit(CarreraDTO carreraDTO) {
		CollectionCarrera.modificarCarrera(carreraMapper.toCarrera(carreraDTO));
	}

}
