package ar.edu.unju.fi.controller;

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

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.service.IDocenteService;
import jakarta.validation.Valid;

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
		return "list/docentes";
	}
	
	@GetMapping("/alta")
	public String getDocenteAltaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("titulo", "Nuevo Docente");
		model.addAttribute("docente", docenteDto);
		model.addAttribute("edicion", edicion);
		return "forms/docentesForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarNuevoDocente(@Valid @ModelAttribute("docente") DocenteDto docenteDto, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("forms/docentesForm");
		} else {
			modelView = new ModelAndView("list/docentes");
			docenteService.saveDocenteDto(docenteDto);
			modelView.addObject("docentes", docenteService.findAll());
		}
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
		return "forms/docentesForm";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@Valid @ModelAttribute("docente") DocenteDto docenteDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("edicion", true);
			return "forms/docentesForm";
		} else {
			docenteService.edit(docenteDto);
			return "redirect:/docente/listado";
		}
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo")int legajo) {
		docenteService.deleteByID(legajo);
		return "redirect:/docente/listado";
	}
	
}