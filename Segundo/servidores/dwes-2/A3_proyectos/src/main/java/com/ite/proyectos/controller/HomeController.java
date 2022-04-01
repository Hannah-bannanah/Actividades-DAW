package com.ite.proyectos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.repository.IntDepartamentoRepo;
import com.ite.proyectos.modelo.service.IntEmpleadoSvc;
import com.ite.proyectos.modelo.service.IntPerfilSvc;

@Controller
public class HomeController {
	
	@Autowired
	IntEmpleadoSvc iEmpleadoSvc;
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/login";
	}
	@GetMapping("/home")
	public String home() {
		return "redirect:/login";

	}
	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUsuario(HttpSession sesion, RedirectAttributes attr, @RequestParam("idemp") int idEmp,
			@RequestParam("email") String correo, @RequestParam("password") String password) {
		Empleado empl = iEmpleadoSvc.validarUsuario(idEmp, correo, password);
		if (empl != null) {
			attr.addFlashAttribute("nombreEmp", empl.getNombre());
			sesion.setAttribute("empl", empl);
			sesion.setAttribute("idPerfil", empl.getPerfil().getIdPerfil());
			return "welcome";
		} else {
			attr.addFlashAttribute("mensajeError", "Credenciales incorrectos");
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/login";
	}
}
