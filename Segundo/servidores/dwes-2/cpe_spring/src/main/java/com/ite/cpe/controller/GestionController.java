package com.ite.cpe.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.cpe.modelo.beans.Producto;
import com.ite.cpe.modelo.beans.Proyecto;
import com.ite.cpe.modelo.dao.IntClienteDao;
import com.ite.cpe.modelo.dao.IntEmpleadoDao;
import com.ite.cpe.modelo.dao.IntProductoDao;
import com.ite.cpe.modelo.dao.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	@Autowired
	IntProyectoDao pyDao;
	
	@Autowired
	IntClienteDao cDao;
	
	@Autowired
	IntEmpleadoDao eDao;
	
	@Autowired
	IntProductoDao pdDao;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@GetMapping("/proyectos")
	public String mostrarProyectos(Model model) {
		model.addAttribute("listaProyectos", pyDao.fetchAll());
		return "proyectos";
	}
	
	@GetMapping("/altaProyecto")
	public String getAltaProyecto(Model model) {
		model.addAttribute("clientes", cDao.fetchAll());
		model.addAttribute("jefes", eDao.findByPerfil(2));
		return "/gestion/altaProyecto";
	}
	
	@PostMapping("/altaProyecto")
	public String altaProyecto(Proyecto proyecto, RedirectAttributes attr) {
		if (pyDao.insertOne(proyecto) == 1) {
			attr.addFlashAttribute("mensajeExito", "El proyecto se ha creado con &eacute;xito");
			return "redirect:/gestion/proyectos";
		} else {
			attr.addFlashAttribute("mensajeError", "No se ha podido crear el proyecto");
			return "redirect:/gestion/altaProyecto";
		}
		
	}
	
	@GetMapping("/altaProducto")
	public String getAltaProducto() {
		return "gestion/altaProducto";
	}
	
	@PostMapping("/altaProducto")
	public String altaProducto(Producto producto, RedirectAttributes attr) {
		if (pdDao.insertOne(producto) == 1)
			attr.addFlashAttribute("mensajeExito", "Producto a&ntilde;adido con &eacute;xito");

		else 
			attr.addFlashAttribute("mensajeError", "El producto no se ha podido a&ntilde;adir");
		return "redirect:/gestion/altaProducto";
	}
}
