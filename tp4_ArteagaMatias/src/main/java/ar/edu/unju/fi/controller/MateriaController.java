package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private MateriaDTO materia;
	@Autowired
	private DocenteDto docente;
	@Autowired
	private CarreraDTO carrera;
	
	@Autowired
	private IMateriaService materiaService;
	@Autowired
	private IDocenteService docenteService;
	@Autowired
	private ICarreraService carreraService;
	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/listado")
	public String getMateriaPage(Model model) {
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("titulo", "Materias");
		return "list/materias";
	}
	
	@GetMapping("/alta")
	public String getMateriaAltaPage(Model model) {
		boolean edicion = false;
		List<DocenteDto> docentes = docenteService.findAll();
	    List<CarreraDTO> carreras = carreraService.findAll();
		if (docentes.isEmpty() || carreras.isEmpty()) {
	        model.addAttribute("error", true);
	    } else {
	        model.addAttribute("error", false);
	    }
		model.addAttribute("titulo", "Nueva Materia");
		model.addAttribute("materia", materia);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docentes", docenteService.findAll());
		model.addAttribute("carreras", carreraService.findAll());
		return "forms/materiasForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarNuevaMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result, Model model) {
		docente = docenteService.findById(materiaDTO.getDocente().getLegajo());
		carrera = carreraService.findById(materiaDTO.getCarrera().getCodigo());
		materiaDTO.setDocente(docente);
		materiaDTO.setCarrera(carrera);
		ModelAndView modelView;
		if (result.hasErrors()) {
			model.addAttribute("docentes", docenteService.findAll());
			model.addAttribute("carreras", carreraService.findAll());
			modelView = new ModelAndView("forms/materiasForm");
		} else {
			modelView = new ModelAndView("list/materias");
			materiaService.saveMateriaDTO(materiaDTO);
			modelView.addObject("materias", materiaService.findAll());
		}
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getMateriasModificarPage(Model model, @PathVariable(value="codigo")int codigo) {
		MateriaDTO materiaEncontrada = new MateriaDTO();
		boolean edicion = true;
		materiaEncontrada = materiaService.findById(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontrada);
		model.addAttribute("titulo", "Modificar Materia");
		model.addAttribute("docentes", docenteService.findAll());
		model.addAttribute("carreras", carreraService.findAll());
		return "forms/materiasForm";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result, Model model) {
		docente = docenteService.findById(materiaDTO.getDocente().getLegajo());
		carrera = carreraService.findById(materiaDTO.getCarrera().getCodigo());
		materiaDTO.setDocente(docente);
		materiaDTO.setCarrera(carrera);
		if (result.hasErrors()) {
			model.addAttribute("docentes", docenteService.findAll());
			model.addAttribute("carreras", carreraService.findAll());
			model.addAttribute("edicion", true);
			return "forms/materiasForm";
		} else {
			materiaService.edit(materiaDTO);
			return "redirect:/materia/listado";
		}
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo")int codigo) {
		alumnoService.removerAlumnosDeMaterias(codigo);
		materiaService.deleteByID(codigo);
		return "redirect:/materia/listado";
	}
}