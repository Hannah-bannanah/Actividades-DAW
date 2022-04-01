package com.ite.libreria_jmp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.ite.libreria_jmp.model.beans.Perfil;
import com.ite.libreria_jmp.model.beans.Tema;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.service.IntLibroSvc;
import com.ite.libreria_jmp.service.IntPedidoSvc;
import com.ite.libreria_jmp.service.IntPerfilSvc;
import com.ite.libreria_jmp.service.IntTemaSvc;
import com.ite.libreria_jmp.service.IntUsuarioSvc;

/**
 * Controlador para las tareas de Administrador
 * @author hannah
 *
 */
@Controller
@RequestMapping("/admon")
public class AdmonController {
	
	@Autowired private IntTemaSvc tsvc;
	
	@Autowired private IntLibroSvc lsvc;
	
	@Autowired private IntPedidoSvc psvc;
	
	@Autowired private IntUsuarioSvc usvc;
	
	@Autowired private IntPerfilSvc perfsvc;
	
	@Autowired private BCryptPasswordEncoder pwe;
	
	@GetMapping("/temas")
	public String mostrarTemas(Model model) {
		List<Tema> temas = tsvc.fetchAll();
		model.addAttribute("listaTemas", temas);
		return "admon/temas";
	}
	
	@PostMapping("/altaTema")
	public String altaTema(Tema tema, RedirectAttributes attr) {
		if (tsvc.insertOne(tema) == 1) 
			attr.addFlashAttribute("mensajeExito", "tema a&ntilde;adido correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "error al a&ntilde;adir el tema");
		return "redirect:/admon/temas";
	}
	
	@GetMapping("/altaLibro")
	public String getAltaLibro(Model model) {
		model.addAttribute("listaTemas", tsvc.fetchAll());
		return "admon/postLibro";
	}
	
	@PostMapping("/altaLibro")
	public String crearLibro(Libro libro, RedirectAttributes attr) {
		Tema tema = tsvc.findById(libro.getTema().getIdTema());
		libro.setTema(tema);
		String novedad = libro.getNovedad() == null ? "n" : libro.getNovedad();
		libro.setNovedad(novedad);
		
		if (libro.getImagen() == "") 
			libro.setImagen("/images/portada.jpg"); //utilizar la imagen por defecto
		
		if (lsvc.insertOne(libro) == 1) {
			attr.addFlashAttribute("mensajeExito", "Libro creado con &eacute;xito");
			return "redirect:/novedades";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al crear el libro");
			return "redirect:/admon/altaLibro";
		}
	}
	
	@GetMapping("/eliminar/{isbn}")
	public String eliminarLibro(@PathVariable("isbn") long isbn, Model model) {
		if (lsvc.eliminar(isbn) == 1) {
			model.addAttribute("mensajeExito", "libro eliminado correctamente");
		} else {
			model.addAttribute("mensajeError", "error al eliminar el libro");
		}
		return "forward:/";
	}
	
	@GetMapping("/editar/{isbn}")
	public String getEditarLibro(@PathVariable("isbn") long isbn, Model model) {
		Libro libro = lsvc.findByIsbn(isbn);
		List<Tema> temas = tsvc.fetchAll();
		if (libro != null) {
			model.addAttribute("libro", libro);
			model.addAttribute("listaTemas", temas);
		}
		return "admon/postLibro";
	}
	
	@PostMapping("/editar/{isbn}")
	public String editarLibro(Libro libro, RedirectAttributes attr) {
		Tema tema = tsvc.findById(libro.getTema().getIdTema());
		libro.setTema(tema);
		String novedad = libro.getNovedad() == null ? "n" : libro.getNovedad();
		libro.setNovedad(novedad);
		
		if (libro.getImagen() == "") 
			libro.setImagen("/images/portada.jpg");
		
		if (lsvc.updateOne(libro) == 1) {
			attr.addFlashAttribute("mensajeExito", "Libro actualizado con &eacute;xito");
			return "redirect:/novedades";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al actualizar el libro");
			return "redirect:/admon/editar/" + libro.getIsbn();
		}
	}
	
	@GetMapping("/pedidos")
	public String verPedidos(Model model) {
		model.addAttribute("listaPedidos", psvc.fetchAll());
		return "admon/pedidos";
	}
	
	@GetMapping("/pedidos/{idPedido}")
	public String verPedidos(@PathVariable("idPedido") int idPedido, Model model) {
		Pedido pedido = psvc.findById(idPedido);
		if (pedido == null) {
			model.addAttribute("mensajeError", "pedido no encontrado");
			return "forward:/admon/pedidos";
		}
		model.addAttribute("pedido", pedido);
		
		//calculamos el importe total del pedido
		BigDecimal total = BigDecimal.valueOf(0);
		for (LineasPedido linea: pedido.getLineasPedidos()) {
			total = total.add(linea.getPrecioVenta().multiply(BigDecimal.valueOf(linea.getCantidad())));
		}
		
		model.addAttribute("total", total);
		return "admon/detallePedido";
	}
	
	@GetMapping("/clientes")
	public String verClientes(Model model) {
		List<Usuario> clientes = usvc.findByProfileDescription("ROL_CLIENTE");
		model.addAttribute("listaClientes", clientes);
		return "admon/clientes";
	}
	
	@GetMapping("/clientes/{username}")
	public String verCliente(@PathVariable("username") String username, Model model) {
		Usuario cliente = usvc.findById(username);
		if (cliente == null) {
			model.addAttribute("mensajeError", "cliente no encontrado");
			return "forward:/clientes";
		}
		
		//Recogemos la informacion de pedidos del cliente
		List<Pedido> pedidos = psvc.findByIdUsuario(cliente.getUsername());
		
		//mapa que mostrara el numero de libros comprados por cada tema
		Map<Tema, Integer> mapaTemas = new HashMap<Tema, Integer>();
		
		BigDecimal totalCompras = BigDecimal.valueOf(psvc.getTotalPagos(cliente.getUsername()));
		int totalLibros = psvc.getTotalLibros(cliente.getUsername());
		
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
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("totalCompras", totalCompras);
		model.addAttribute("totalTemas", mapaTemas.keySet().size());
		model.addAttribute("totalLibros", totalLibros);
		model.addAttribute("mapaTemas", mapaTemas);
		return "admon/detalleCliente";
	}
	
	@GetMapping("/usuarios")
	public String verUsuarios(Model model) {
		model.addAttribute("listaUsuarios", usvc.fetchAll());
		return "admon/usuarios";
	}
	
	@GetMapping("/altaUsuario")
	public String getAltaUsuario(Model model) {
		model.addAttribute("listaPerfiles", perfsvc.fetchAll());
		return "admon/altaUsuario";
	}
	
	@PostMapping("/altaUsuario")
	public String altaUsuario(Usuario usuario, RedirectAttributes attr, 
			@RequestParam("perfil") List<Integer> perfilesIds) {
		usuario.setFechaAlta(new Date());
		int enabled = usuario.getEnabled() == 1 ? 1: 0;
		usuario.setEnabled(enabled);
		usuario.setPassword(pwe.encode(usuario.getPassword()));
		
		/*
		 * como un usuario puede tener varios perfiles, 
		 * recorremos la lista de idPerfil enviada con el formulario
		 * y creamos una lista de perfiles
		 */
		List<Perfil> perfiles = new ArrayList<Perfil>();
		for (Integer idPerfil : perfilesIds) {
			Perfil perfil = perfsvc.findById(idPerfil);
			perfiles.add(perfil);
		}
		usuario.setPerfiles(perfiles);
		
		if (usvc.insertOne(usuario) == 1) {
			attr.addFlashAttribute("mensajeExito", "Alta procesada con &eacute;xito");
			return "redirect:/admon/usuarios";
		} else {
			attr.addFlashAttribute("mensajeError", "Error al procesar el alta");
			return "redirect:/admon/altaUsuario";
		}	
	}
	
	@GetMapping("/perfiles")
	public String verPerfiles(Model model) {
		model.addAttribute("listaPerfiles", perfsvc.fetchAll());
		return "admon/perfiles";
	}
	
	@PostMapping("/altaPerfil")
	public String verPerfiles(Perfil perfil, RedirectAttributes attr) {
		if (perfsvc.insertOne(perfil) == 1) {
			attr.addFlashAttribute("mensajeExito", "perfil creado con &eacute;xito");
		} else {
			attr.addFlashAttribute("mensajeError", "error al crear el perfil");
		}
		return "redirect:/admon/perfiles";
	}

}
