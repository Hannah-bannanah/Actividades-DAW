package com.ite.jana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.jana.model.beans.Evento;
import com.ite.jana.service.IntEventoSvc;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/eventos")
public class EventosController {
	
	@Autowired
	private IntEventoSvc esvc;
	
	/*
	 * descomentar ese metodo para activar un endpoint que
	 * crea 20 registros de eventos en la base de dados 
	 * (requiere que exista al menos un registro en la tabla tipos)
	 */
	/*
	 * @GetMapping("inicializar") public String inicializarEventos() {
	 * esvc.inicializar(); return "ok"; }
	 */
	
	@GetMapping("activos")
	public List<Evento> mostrarActivos(){
		return esvc.findActivos();
	}
	
	@GetMapping("destacados")
	public List<Evento> mostrarDestacados(){
		return esvc.findDestacados();
	}
	
	@GetMapping("buscarEventos/{subcadena}")
	public List<Evento> buscarEventos(@PathVariable("subcadena") String subcadena) {
		return esvc.buscarSubcadena(subcadena);
	}
	
	@GetMapping("plazasQuedan/{idEvento}")
	public String mostarPlazasDisponibles(@PathVariable("idEvento") int idEvento) {
		int plazasDisponibles = esvc.getPlazasDisponibles(idEvento);
		if (plazasDisponibles == -1) return "{'error': 'evento no existe'}";
		return "{'quedan_plazas': " + plazasDisponibles + " }";
	}
	
	@GetMapping("verUno/{idEvento}")
	public Evento verUno(@PathVariable("idEvento") int idEvento) {
		return esvc.findById(idEvento);
	}

	@PostMapping("alta")
	public String altaEvento(@RequestBody Evento evento) {
		int altaEvento = esvc.crearEvento(evento);
		if (altaEvento == 1)
			return "Evento dado de alta";
		else if (altaEvento == -1)
			return "Evento ya existe";
		else 
			return "No se pudo dar de alta el evento";
	}
	
	@PutMapping("modificar")
	public String modificarEvento(@RequestBody Evento evento) {
		int eventoModificado = esvc.modificarEvento(evento);
		if (eventoModificado == 1)
			return "Evento modificado";
		else if (eventoModificado == -1)
			return "Evento no existe";
		else 
			return "No se pudo actualizar el evento";
	}
	
	@DeleteMapping("eliminar/{idEvento}")
	public String eliminarEvento(@PathVariable("idEvento") int idEvento) {
		return esvc.eliminarEvento(idEvento) == 1 ? "Evento eliminado" : "El evento no se pudo eliminar";
	}
}
