package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
public class InscripcionController {

    @Autowired
    private IAlumnoService alumnoService;

    @Autowired
    private IMateriaService materiaService;

    @GetMapping("/inscripcion")
    public String showInscripcionForm(Model model) {
        List<AlumnoDTO> alumnos = alumnoService.findAll();
        List<MateriaDTO> materias = materiaService.findAll();
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("materias", materias);
        return "list/alumnos";
    }

    @GetMapping("/inscripcion/form")
    public String showInscripcionForm(@RequestParam("alumnoId") Integer alumnoId, Model model) {
        AlumnoDTO alumno = alumnoService.findById(alumnoId);
        List<MateriaDTO> materias = materiaService.findAll();
        model.addAttribute("alumno", alumno);
        model.addAttribute("materias", materias);
        return "forms/inscripcionForm";
    }

    @PostMapping("/inscripcion")
    public String inscribirAlumno(@RequestParam("alumnoId") Integer alumnoId, @RequestParam("materiaId") Integer materiaId, Model model) {
        List<MateriaDTO> materias = materiaService.findAll();
        if (materias.isEmpty()) {
            model.addAttribute("error", "No hay materias disponibles para inscripción.");
            return "forms/inscripcionForm";
        }

        try {
            alumnoService.inscribirAlumno(alumnoId, materiaId);
            model.addAttribute("message", "Inscripción realizada con éxito");
        } catch (RuntimeException e) {
            model.addAttribute("message", "Error en la inscripción: " + e.getMessage());
        }
        return "redirect:/inscripcion";
    }

}