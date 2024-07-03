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

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.IAlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoDTO alumnoDTO;
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/listado")
	public String getAlumnoPage(Model model) {
		model.addAttribute("alumnos", alumnoService.findAll());
		model.addAttribute("titulo", "Alumnos");
		return "alumnos";
	}
	
	@GetMapping("/alta")
	public String getAlumnoAltaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("titulo", "Nuevo Alumno");
		model.addAttribute("alumno", alumnoDTO);
		model.addAttribute("edicion", edicion);
		return "alumnosForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarNuevoAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO) {
		ModelAndView modelView = new ModelAndView("alumnos");
		alumnoService.saveAlumnoDTO(alumnoDTO);
		modelView.addObject("alumnos", alumnoService.findAll());
		return modelView;
	}
	
	@GetMapping("/modificar/{dni}")
	public String getAlumnosModificarPage(Model model, @PathVariable(value="dni")int dni) {
		AlumnoDTO alumnoEncontrado = new AlumnoDTO();
		boolean edicion = true;
		alumnoEncontrado = alumnoService.findById(dni);
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontrado);
		model.addAttribute("titulo", "Modificar Alumno");
		return "alumnosForm";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO) {
		alumnoService.edit(alumnoDTO);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable(value="dni")int dni) {
		alumnoService.deleteByID(dni);
		return "redirect:/alumno/listado";
	}
}