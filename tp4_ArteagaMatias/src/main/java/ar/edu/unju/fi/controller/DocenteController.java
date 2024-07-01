package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	private DocenteDto docenteDto;
	@Autowired
	private IDocenteService docenteService;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("docentes", docenteService.findAll());
		model.addAttribute("titulo", "Docentes");
		return "docentes";
	}
	
	@GetMapping("/alta")
	public String getDocenteAltaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("titulo", "Nuevo Docente");
		model.addAttribute("docente", docenteDto);
		model.addAttribute("edicion", edicion);
		return "docentesForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarNuevoDocente(@ModelAttribute("docente") DocenteDto docenteDto) {
		ModelAndView modelView = new ModelAndView("docentes");
		docenteService.saveDocenteDto(docenteDto);
		modelView.addObject("docentes", docenteService.findAll());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getDocentesModificarPage(Model model, @PathVariable(value="legajo")int legajo) {
		DocenteDto docenteEncontrado = new DocenteDto();
		boolean edicion = true;
		docenteEncontrado = docenteService.findById(legajo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontrado);
		model.addAttribute("titulo", "Modificar Docente");
		return "docentesForm";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") DocenteDto docenteDto) {
		docenteService.edit(docenteDto);
		return "redirect:/docente/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo")int legajo) {
		docenteService.deleteByID(legajo);
		return "redirect:/docente/listado";
	}
	
}