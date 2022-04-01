package com.ite.libreria_jmp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.Perfil;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.service.CarritoSvc;
import com.ite.libreria_jmp.service.IntLibroSvc;
import com.ite.libreria_jmp.service.IntPerfilSvc;
import com.ite.libreria_jmp.service.IntUsuarioSvc;

/**
 * Controlador basico
 * @author hannah
 *
 */
@Controller
public class HomeController {
	
	@Autowired private IntLibroSvc lSvc;
	
	@Autowired IntUsuarioSvc uSvc;
	
	@Autowired CarritoSvc cSvc;
	
	@Autowired IntPerfilSvc perfsvc;
	
	@Autowired BCryptPasswordEncoder pwe;
	
	@GetMapping("/")
	public String inicio() {
		/*
		 * Este endpoint se usara para la pagina de inicio mostrada a usuarios 
		 * no autenticados. De momento redirige a la pagina de novedades
		 */
		return "redirect:/novedades";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login/success")
	public String inicio(Authentication auth, HttpSession sesion) {
		if (auth != null) {
			Usuario usuario = uSvc.findById(auth.getName());
			if (sesion.getAttribute("usuario") == null) {
				usuario.setPassword(null);
				sesion.setAttribute("usuario", usuario);
			}
			/*
			 * Creamos el carrito cada vez que se inicia sesion,
			 * el carrito no se guarda de una sesion a otra
			 */
			cSvc.crearCarrito(); 
		}
		return "redirect:/";
	}
	
	@GetMapping("/login/error")
	public String loginFailure(Model model) {
		model.addAttribute("mensajeError", "credenciales incorrectos");
		return "forward:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion, HttpServletRequest req) {
		sesion.invalidate();
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(req, null, null);
		return "redirect:/login";
	}
	
	@GetMapping("/novedades")
	public String novedades(Model model) {
		List<Libro> libros = lSvc.fetchNovedades();
		model.addAttribute("listaLibros", libros);
		return "novedades";
	}
	
	@GetMapping("/alta")
	public String getRegistrarse() {
		return "registro";
	}
	
	@PostMapping("alta")
	public String registrarse(Usuario cliente, RedirectAttributes attr) {
		if (uSvc.findById(cliente.getUsername()) != null) {
			attr.addFlashAttribute("mensajeError", "Username ya existe");
			return "redirect:/alta";
		}
		cliente.setEnabled(1); 
		cliente.setFechaAlta(new Date());
		
		List<Perfil> perfiles = new ArrayList<Perfil>();
		perfiles.add(perfsvc.buscarPorDescripcion("ROL_CLIENTE"));
		cliente.setPerfiles(perfiles);
		cliente.setPassword(pwe.encode(cliente.getPassword()));
		
		if (uSvc.insertOne(cliente) == 1) {
			attr.addFlashAttribute("mensajeExito", "Registro completo con &eacute;xito");
			return "redirect:/login";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al procesar el alta");
			return "redirect:/alta";
		}

	}
}
