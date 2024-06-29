package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model model) {
		model.addAttribute("carreras", carreraService.findAll());
		model.addAttribute("titulo", "Carreras");
		return "carreras";
	}
	
	@GetMapping("/alta")
	public String getCarrerasAltaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("titulo", "Nueva Carrera");
		model.addAttribute("carrera", carreraDTO);
		model.addAttribute("edicion", edicion);
		return "carrerasForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarNuevvaCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) {
		ModelAndView modelView = new ModelAndView("carreras");
		carreraDTO.setEstado(true);
		carreraService.saveCarreraDTO(carreraDTO);
		modelView.addObject("carreras", carreraService.findAll());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getCarrerasModificarPage(Model model, @PathVariable(value="codigo")int codigo) {
		CarreraDTO carreraEncontrada = new CarreraDTO();
		boolean edicion = true;
		carreraEncontrada = carreraService.findById(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontrada);
		model.addAttribute("titulo", "Modificar carrera");
		return "carrerasForm";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) {
		carreraService.edit(carreraDTO);
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo")int codigo) {
		carreraService.deleteByID(codigo);
		return "redirect:/carrera/listado";
	}
	
}