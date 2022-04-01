package com.ite.libreria_jmp.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.LineasPedido;
import com.ite.libreria_jmp.model.beans.Pedido;
import com.ite.libreria_jmp.model.beans.Tema;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.service.CarritoSvc;
import com.ite.libreria_jmp.service.IntLibroSvc;
import com.ite.libreria_jmp.service.IntPedidoSvc;
import com.ite.libreria_jmp.service.IntTemaSvc;
import com.ite.libreria_jmp.service.IntUsuarioSvc;

/**
 * Controlador para las tareas del cliente
 * @author hannah
 *
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired private IntLibroSvc lSvc;
	
	@Autowired private IntTemaSvc tSvc;
	
	@Autowired private IntUsuarioSvc uSvc;
	
	@Autowired private IntPedidoSvc pSvc;
	
	@Autowired private CarritoSvc cSvc;
	
	@GetMapping("/tema")
	public String getBuscarPorTema(Model model) {
		List<Tema> temas = tSvc.fetchAll();
		model.addAttribute("listaTemas", temas);
		return "buscarTema";
	}
	
	@PostMapping("/tema")
	public String buscarPorTema(Tema tema, RedirectAttributes attr) {
		List<Libro> libros = lSvc.fetchByTema(tema);
		attr.addFlashAttribute("listaLibros", libros);
		return "redirect:/cliente/tema";
	}
	
	@GetMapping("/buscar")
	public String getBuscarPorCadena(Model model) {
		return "buscarTitulo";
	}
	
	@PostMapping("/buscar")
	public String buscarPorCadena(@RequestParam("cadena") String cadena, 
			RedirectAttributes attr) {
		if (cadena.trim() != "") {
			List<Libro> libros = lSvc.searchByTitle(cadena.trim());
			attr.addFlashAttribute("listaLibros", libros);
		} else {
			attr.addFlashAttribute("listaLibros", lSvc.fetchAll());
		}
		return "redirect:/cliente/buscar";
	}
	
	@GetMapping("/verDetalle/{isbn}")
	public String verDetalle(@PathVariable("isbn") long isbn, Model model, 
			RedirectAttributes attr) {
		Libro libro = lSvc.findByIsbn(isbn);
		if (libro != null) {
			model.addAttribute(libro);
			return "detalleLibro";
		} else {
			attr.addFlashAttribute("mensajeError", "Libro no encontrado");
			return "redirect:/";
		}
	}
	
	@GetMapping("/misDatos")
	public String verDatos(Model model, HttpSession sesion) {
		Usuario cliente = (Usuario) sesion.getAttribute("usuario");
		cliente = uSvc.findById(cliente.getUsername());
		model.addAttribute("cliente", cliente);
		
		//Recogemos la informacion de pedidos del cliente
		List<Pedido> pedidos = pSvc.findByIdUsuario(cliente.getUsername());
		
		//mapa que mostrara el numero de libros comprados por cada tema
		Map<Tema, Integer> mapaTemas = new HashMap<Tema, Integer>();
		
		BigDecimal totalCompras = BigDecimal.valueOf(pSvc.getTotalPagos(cliente.getUsername()));
		int totalLibros = pSvc.getTotalLibros(cliente.getUsername());
		
		//recorremos el array de pedidos para rellenar el mapa y calcular totales
		for (Pedido pedido: pedidos) {
			for (LineasPedido linea: pedido.getLineasPedidos()) {
				if (mapaTemas.containsKey(linea.getLibro().getTema())) {
					int contador = mapaTemas.get(linea.getLibro().getTema());
					mapaTemas.put(linea.getLibro().getTema(), contador + 1);
				} else {
					mapaTemas.put(linea.getLibro().getTema(), 1);
				}
			}
		}
		
		model.addAttribute("totalCompras", totalCompras);
		model.addAttribute("totalTemas", mapaTemas.keySet().size());
		model.addAttribute("totalLibros", totalLibros);
		model.addAttribute("listaPedidos", pedidos);		
		return "cliente/misDatos";
	}

}
