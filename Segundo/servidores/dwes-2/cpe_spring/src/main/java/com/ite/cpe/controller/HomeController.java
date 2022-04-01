package com.ite.cpe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.cpe.modelo.beans.Empleado;
import com.ite.cpe.modelo.dao.IntEmpleadoDao;

@Controller
public class HomeController {

	@Autowired
	private IntEmpleadoDao eDao;
	
	@GetMapping("/")
	public String start() {
		return "forward:/login";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession sesion, RedirectAttributes attr,
			@RequestParam("idEmpl") int idEmpl, 
			@RequestParam("correo") String correo, @RequestParam("password") String password) {
		Empleado empleado = eDao.validarUsuario(idEmpl, correo, password);
		if (empleado != null) {
			sesion.setAttribute("empleado", empleado);
			return "welcome";
		} else {
			attr.addFlashAttribute("mensajeError", "credenciales incorrectos");
			return "redirect:/login";
		}

	}
	
	@GetMapping("/cerrarSesion")
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}

}
