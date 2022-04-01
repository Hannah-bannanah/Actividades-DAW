package com.ite.libreria_jmp.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.service.IntCarritoSvc;
import com.ite.libreria_jmp.service.IntLibroSvc;

/**
 * Controlador del carrito
 * @author hannah
 *
 */
@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired IntCarritoSvc cSvc;
	
	@Autowired IntLibroSvc lSvc;
	
	@Component
	public class CarritoValidator extends OncePerRequestFilter{

		/**
		 * Valida si existe un carrito y crea uno nuevo si no es asi
		 */
		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {
			if (cSvc.carritoIsNull()) cSvc.crearCarrito();
			filterChain.doFilter(request, response);
		}

	}	
	
	@GetMapping("/verCarrito")
	public String verCarrito(Model model) {
		model.addAttribute("carrito", cSvc.getLineas());
		return "cliente/carrito";
	}
	
	@GetMapping("/anadir/{isbn}")
	public String anadir(@PathVariable("isbn") long isbn,
			RedirectAttributes attr) {
		Libro libro = lSvc.findByIsbn(isbn);
		if (libro != null && cSvc.anadirLibro(libro))
			attr.addFlashAttribute("mensajeExito", "libro a&ntilde;adido al carrito");
		else 
			attr.addFlashAttribute("mensajeError", "error al a&ntilde;adir el libro al carrito");
		
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{isbn}")
	public String eliminar(@PathVariable("isbn") long isbn,
			RedirectAttributes attr) {
		Libro libro = lSvc.findByIsbn(isbn);
		if (libro !=null && cSvc.eliminarLibro(libro))
			attr.addFlashAttribute("mensajeExito", "libro eliminado del carrito");
		else 
			attr.addFlashAttribute("mensajeError", "error al eliminar el libro del carrito");
		return "redirect:/carrito/verCarrito";
	}
	
	@GetMapping("/realizarPedido")
	public String realizarPedido(HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		cSvc.realizarPedido(usuario);
		cSvc.crearCarrito();
		return "redirect:/";
	}
}
