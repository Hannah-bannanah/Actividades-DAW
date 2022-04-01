package com.ite.eventos.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.eventos.modelo.bean.Cliente;
import com.ite.eventos.modelo.services.IntClienteService;

@Controller
@RequestMapping("/clientes")
public class GestionClientes {

	
	@Autowired
	private IntClienteService clienteService;
	
	@GetMapping("/registrar")
	public String mostrarFormularioRegistro(RedirectAttributes atributos, HttpSession sesionUsuario) {
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 403);
			atributos.addFlashAttribute("nombreError", "Forbidden");
			atributos.addFlashAttribute("mensajeError", "Cierra sesion para registrar un nuevo cliente");
			return "redirect:/error";
		}
			
		return "altaCliente";
	}
	@PostMapping("/registrar")
	public String altaCliente(RedirectAttributes atributos, Cliente cliente) {
		if (clienteService.altaCliente(cliente) == 0) {		
			atributos.addFlashAttribute("mensajeError", "No se ha podido registrar el cliente");
			return "redirect:registrar";
		}
		else {
			atributos.addFlashAttribute("username", cliente.getUsername());
			return "redirect:login";
		}
		
	}
	
	@GetMapping("/login")
	public String mostrarFormularioLogin(RedirectAttributes atributos, HttpSession sesionUsuario) {
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 403);
			atributos.addFlashAttribute("nombreError", "Forbidden");
			atributos.addFlashAttribute("mensajeError", "Cierra sesion para iniciar sesion");
			return "redirect:/error";
		}
		return "loginCliente";
	}
	@PostMapping("/login")
	public String loginUsuario(RedirectAttributes atributos, 
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			HttpSession  sesionUsuario, Model model) {
		
		if (clienteService.login(username, password) == 1) {
			Cliente cliente = clienteService.findByUsername(username);
			sesionUsuario.setAttribute("idCliente", cliente.getIdCliente());
			return "redirect:inicio";
		} else {
			atributos.addFlashAttribute("mensajeError", "nombre de usuario o contraseña incorrecotos");
			return "redirect:login";
		}
			
	}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession sesionUsuario) {
		sesionUsuario.invalidate();
		return "redirect:login";
	}
	
	@GetMapping("/inicio")
	public String inicioCliente(Model model, HttpSession sesionUsuario) {
		Cliente cliente = clienteService.findById((Integer) sesionUsuario.getAttribute("idCliente"));
		model.addAttribute("nombre", cliente.getNombre());
		return "welcomeCliente";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(HttpSession sesionUsuario) {
		return "redirect:/eventos/activos";
	}
	
	@GetMapping("/destacados")
	public String mostrarDestacados(HttpSession sesionUsuario) {
		return "redirect:/eventos/destacados";
	}
}
