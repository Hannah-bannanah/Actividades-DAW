package com.ite.eventos.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.eventos.modelo.services.IntReservaService;

@Controller
@RequestMapping("/reservas")
public class GestionReservas {
	
	@Autowired
	private IntReservaService reservaService;
	
	@GetMapping
	public String mostrarTodas(Model model, HttpSession sesionUsuario) {
		if (sesionUsuario.getAttribute("idCliente") == null) 
			model.addAttribute("reservas", reservaService.fetchAll());
		else {
			int idCliente = (Integer) sesionUsuario.getAttribute("idCliente");
			model.addAttribute("reservas", reservaService.findByCliente(idCliente));
		}			
		return "reservas";
	}

	@PostMapping("/reservar/{idEvento}")
	public String reservar(RedirectAttributes atributos, HttpSession sesionUsuario,
			@PathVariable("idEvento") int idEvento,
			@RequestParam("cantidad") int cantidad) {
		int idCliente = (Integer) sesionUsuario.getAttribute("idCliente");
		
		if (reservaService.reservar(idEvento, idCliente, cantidad) == 0) {
			atributos.addFlashAttribute("mensajeError", "la reserva no se ha podido realizar");
		} else {
			atributos.addFlashAttribute("mensajeExito", "la reserva se ha realizado correctamente");
		}
			
			
		return "redirect:/eventos/{idEvento}";
	}
}
