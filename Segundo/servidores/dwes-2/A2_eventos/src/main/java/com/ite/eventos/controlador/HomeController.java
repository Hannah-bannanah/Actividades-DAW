package com.ite.eventos.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {	
	
	@GetMapping("/home")
	public String home(Model model, HttpSession sesionUsuario) {
		if (sesionUsuario.getAttribute("cliente") != null) {
			return "redirect:/eventos/activos";
		}
		return "redirect:/eventos/todos";
	}
	
}
