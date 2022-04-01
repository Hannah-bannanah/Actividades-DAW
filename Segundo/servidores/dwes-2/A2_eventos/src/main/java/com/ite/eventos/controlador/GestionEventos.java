package com.ite.eventos.controlador;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.bean.Tipo;
import com.ite.eventos.modelo.repository.IntTipoRepo;
import com.ite.eventos.modelo.services.IntEventoService;
import com.ite.eventos.modelo.services.IntReservaService;


@Controller
@RequestMapping("/eventos")
public class GestionEventos {
	
	@Autowired
	private IntTipoRepo iTipos;
	
	@Autowired
	private IntEventoService eventoService;
	
	@Autowired
	private IntReservaService reservaService;
	
	@Autowired 
	private PropertyEditor tipoEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		wdb.registerCustomEditor(Tipo.class, tipoEditor);
	}
	
	@GetMapping("/todos")
	public String mostrarTodos(Model model, HttpSession sesionUsuario) {
		model.addAttribute("eventos", eventoService.fetchAll());
		if (sesionUsuario.getAttribute("idCliente") != null) {
			model.addAttribute("errorMessage", "Acceso denegado");
			return "redirect:activos";
		} 
		return "index";
	}
	
	@GetMapping("/{id}") 
	public String mostrarEvento(Model model, HttpSession sesionUsuario,
			@PathVariable("id") int idEvento, RedirectAttributes atributos) {
		
		Evento evento = eventoService.findById(idEvento);
		int plazasDisponibles = evento.getMaxAforo() - reservaService.plazasReservadas(idEvento);
		model.addAttribute("evento", evento);
		model.addAttribute("plazasDisponibles", plazasDisponibles);
		return "detallesEvento";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model, HttpSession sesionUsuario) {
		model.addAttribute("eventosActivos", eventoService.findByEstado("activo"));
		if (sesionUsuario.getAttribute("idCliente") != null) return "eventosFiltradosCliente";
		return "eventosFiltrados";
	}
	
	@GetMapping("/cancelados")
	public String mostrarCancelados(Model model, HttpSession sesionUsuario, RedirectAttributes atributos) {
		model.addAttribute("eventosCancelados", eventoService.findByEstado("cancelado"));
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 401);
			atributos.addFlashAttribute("nombreError", "Cotilla!");
			atributos.addFlashAttribute("mensajeError", "Deja de intentar meter las narices donde no te llaman");
			return "redirect:/error";
		} 
		return "eventosFiltrados";
	}
	
	@GetMapping("/destacados")
	public String mostrarDestacados(Model model, HttpSession sesionUsuario) {
		model.addAttribute("eventosDestacados", eventoService.fetchDestacados());
		if (sesionUsuario.getAttribute("idCliente") != null) return "eventosFiltradosCliente";
		return "eventosFiltrados";
	}
	
	@GetMapping("/alta")
	public String mostrarFormularioAlta(Model model, HttpSession sesionUsuario, RedirectAttributes atributos) {
		model.addAttribute("tipos", iTipos.fetchAll());
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 401);
			atributos.addFlashAttribute("nombreError", "Cotilla!");
			atributos.addFlashAttribute("mensajeError", "Deja de intentar meter las narices donde no te llaman");
			return "redirect:/error";
		} 
		return "postEvento";
	}
	
	@PostMapping("/alta")
	public String registrarEvento(Evento evento) {
		
		//generamos valores no pedidos al usuario
		List<Evento> eventos = eventoService.fetchAll();
		int ultimoId = eventos.get(eventos.size() - 1).getIdEvento();
		evento.setIdEvento(ultimoId + 1);

		// actualizar destacado si el checkbox esta vacio
		if (evento.getDestacado() != "s".charAt(0)) evento.setDestacado("n".charAt(0));
		
		eventoService.registrarEvento(evento);
		return "redirect:/eventos/todos";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(Model model, HttpSession sesionUsuario,
			@PathVariable("id") int idEvento, RedirectAttributes atributos) {
//		
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 401);
			atributos.addFlashAttribute("nombreError", "Cotilla!");
			atributos.addFlashAttribute("mensajeError", "Deja de intentar meter las narices donde no te llaman");
			return "redirect:/error";
		} 
		
		Evento evento = eventoService.findById(idEvento);
		model.addAttribute("evento", evento);
		model.addAttribute("tipos", iTipos.fetchAll());
		
//		//modificar el formato de la fecha de inicio
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaFormateada = sdf.format(evento.getFechaInicio());
		model.addAttribute("fechaInicio", fechaFormateada);
		
		/*
		 * pasamos por separado un boolean especificando si el evento
		 * es destacado
		*/
		boolean isDestacado = evento.getDestacado() == "s".charAt(0);
		model.addAttribute("isDestacado", isDestacado);
		
		
		model.addAttribute("editar", true); //variable utilizada por el formulario
		return "postEvento";
	}
	
	@PostMapping("/editar/{id}")
	public String editarEvento(Evento evento, @PathVariable("id") int idEvento) {
		
		// actualizar destacado si el checkbox esta vacio
		if (evento.getDestacado() != "s".charAt(0)) evento.setDestacado("n".charAt(0));
		
		
		eventoService.editarEvento(evento, idEvento);
		return "redirect:/eventos/todos";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelarEvento(Model model, HttpSession sesionUsuario,
			@PathVariable("id") int idEvento, RedirectAttributes atributos) {
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 401);
			atributos.addFlashAttribute("nombreError", "Cotilla!");
			atributos.addFlashAttribute("mensajeError", "Deja de intentar meter las narices donde no te llaman");
			return "redirect:/error";
		} 
		eventoService.cancelarEvento(idEvento);
		return "redirect:/eventos/todos";
	}
	
	@GetMapping("/activar/{id}")
	public String ActivarEvento(Model model, HttpSession sesionUsuario,
			@PathVariable("id") int idEvento, RedirectAttributes atributos) {
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 401);
			atributos.addFlashAttribute("nombreError", "Cotilla!");
			atributos.addFlashAttribute("mensajeError", "Deja de intentar meter las narices donde no te llaman");
			return "redirect:/error";
		} 
		eventoService.activarEvento(idEvento);
		return "redirect:/eventos/cancelados";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEvento(Model model, HttpSession sesionUsuario,
			@PathVariable("id") int idEvento, RedirectAttributes atributos) {
		if (sesionUsuario.getAttribute("idCliente") != null) {
			atributos.addFlashAttribute("codigoError", 401);
			atributos.addFlashAttribute("nombreError", "Cotilla!");
			atributos.addFlashAttribute("mensajeError", "Deja de intentar meter las narices donde no te llaman");
			return "redirect:/error";
		} 
		eventoService.eliminarEvento(idEvento);
		return "redirect:/eventos/todos";
	}

}
