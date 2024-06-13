package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/principal")
	public String getIndexPage(Model model) {
		model.addAttribute("titulo", "Principal");
		return "index";
	}
}
