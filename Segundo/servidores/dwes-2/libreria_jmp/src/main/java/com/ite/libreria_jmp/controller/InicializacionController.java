package com.ite.libreria_jmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ite.libreria_jmp.service.IntLibroSvc;
import com.ite.libreria_jmp.service.IntPerfilSvc;
import com.ite.libreria_jmp.service.IntTemaSvc;
import com.ite.libreria_jmp.service.IntUsuarioSvc;

/**
 * Endpoint utilizado para inicializar la bbdd con varios registros.<br>
 * Es necesario inicializar perfiles antes que usuarios y temas antes que libros
 * @author hannah
 *
 */
@Controller
@RequestMapping("/inicializar")
public class InicializacionController {
	@Autowired
	private IntPerfilSvc perfSvc;
	
	@Autowired
	private IntUsuarioSvc uSvc;
	
	@Autowired
	private IntTemaSvc tSvc;
	
	@Autowired
	private IntLibroSvc lSvc;
	
	@GetMapping("/perfiles")
	public String initPerfiles(Model model) {
		perfSvc.inicializarPerfiles();
		model.addAttribute("mensajeExito", "Perfiles inicializados");
		return "forward:/";
	}
	
	@GetMapping("/usuarios")
	public String initUsuarios(Model model) {
		uSvc.iniciaLizarUsuarios();
		model.addAttribute("mensajeExito", "Usuarios inicializados");
		return "forward:/";
	}
	
	@GetMapping("/temas")
	public String initTemas(Model model) {
		tSvc.inicializarTemas();
		model.addAttribute("mensajeExito", "Temas inicializados");
		return "forward:/";
	}
	
	@GetMapping("/libros")
	public String initLibros(Model model) {
		lSvc.inicializarLibros();
		model.addAttribute("mensajeExito", "Libros inicializados");
		return "forward:/";
	}
	
}
