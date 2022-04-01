package com.ite.proyectos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.ite.proyectos.modelo.bean.Cliente;
import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.service.IntClienteSvc;
import com.ite.proyectos.modelo.service.IntEmpleadoSvc;
import com.ite.proyectos.modelo.service.IntProductoSvc;
import com.ite.proyectos.modelo.service.IntProyectoSvc;
import com.ite.proyectos.util.*;

@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	@Autowired
	IntEmpleadoSvc iEmpleadoSvc;
	
	@Autowired
	IntClienteSvc iClienteSvc;
	
	@Autowired
	IntProyectoSvc iProyectoSvc;
	
	@Autowired
	IntProductoSvc iProductoSvc;
	
	@Autowired
	CustomClienteEditor clienteEditor;
	
	@Autowired
	CustomEmpleadoEditor empleadoEditor;

	@GetMapping("")
	public String welcome(HttpSession sesion) {
		return "welcome";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		wdb.registerCustomEditor(Cliente.class, clienteEditor);
		wdb.registerCustomEditor(Empleado.class, empleadoEditor);
	}
	
	@GetMapping("/proyectos")
	public String morstrarProyectos(Model model) {
		model.addAttribute("listaProyectos", iProyectoSvc.fetchAll());
		return "proyectos";
	}
	
	@GetMapping("/altaProyecto")
	public String mostrarAltaProyecto(Model model) {
		model.addAttribute("clientes", iClienteSvc.fetchAll());
		model.addAttribute("jefes", iEmpleadoSvc.fetchJefes());
		return "gestion/altaProyecto";
	}
	
	@PostMapping("/altaProyecto")
	public String crearProyecto(RedirectAttributes attr, Proyecto proyecto) {
		if (iProyectoSvc.altaProyecto(proyecto) == 1) {
			attr.addFlashAttribute("mensajeExito", "Proyecto creado con &eacute;xito");
			return "redirect:/gestion/proyectos";
		}
		else {
			attr.addFlashAttribute("mensajeError", "No se ha podido crear el proyecto");
			return "redirect:/gestion/altaProyecto";			
		}
	}
	
	@GetMapping("/terminar/{id}")
	public String terminarProyecto(@PathVariable("id") String idProyecto, RedirectAttributes attr) {
		if (iProyectoSvc.terminarProyecto(idProyecto) == 1)
			attr.addFlashAttribute("mensajeExito", "Proyecto terminado correctamente");
		else
			attr.addFlashAttribute("mensajeError", "No se ha podido terminar el proyecto");
		return "redirect:/gestion/proyectos";
		
	}
	
	@GetMapping("/altaProducto")
	public String mostrarAltaProducto() {
		return "gestion/altaProducto";
	}
	
	@PostMapping("/altaProducto")
	public String altaProducto(Producto producto, RedirectAttributes attr) {
		if (iProductoSvc.altaProducto(producto) == 1)
			attr.addFlashAttribute("mensajeExito", "El producto se ha creado con &eacute;xito");
		else
			attr.addFlashAttribute("mensajeError", "El producto no se ha podido crear");
		return "redirect:/gestion/altaProducto";
	}
	
}
