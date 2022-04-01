package com.ite.proyectos.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;
import com.ite.proyectos.modelo.service.IntEmpleadoSvc;
import com.ite.proyectos.modelo.service.IntProductoSvc;
import com.ite.proyectos.modelo.service.IntProyectoSvc;
import com.ite.proyectos.util.CustomEmpleadoEditor;
import com.ite.proyectos.util.CustomProductoEditor;
import com.ite.proyectos.util.CustomProyectoEditor;

@Controller
@RequestMapping("/jefe")
public class JefeController {
	@Autowired
	IntEmpleadoSvc iEmpleadoSvc;
	
	@Autowired
	IntProyectoSvc iProyectoSvc;
	
	@Autowired
	IntProductoSvc iProductoSvc;
	
	@Autowired
	CustomProyectoEditor proyectoEditor;
	
	@Autowired
	CustomEmpleadoEditor empleadoEditor;
	
	@Autowired
	CustomProductoEditor productoEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		wdb.registerCustomEditor(Proyecto.class, proyectoEditor);
		wdb.registerCustomEditor(Empleado.class, empleadoEditor);
		wdb.registerCustomEditor(Producto.class, productoEditor);
	}
	
	@GetMapping("")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/proyectos")
	public String mostrarProyectos(Model model, HttpSession sesion) {
		Empleado jefe = (Empleado) sesion.getAttribute("empl");
		model.addAttribute("listaProyectos", iProyectoSvc.findByJefe(jefe));
		return "proyectos";
	}
	
	@GetMapping("/empleados")
	public String mostrarEmpleados() {
		for (int i=0; i < 20; i++) {
			System.out.println(iEmpleadoSvc.fetchAll().get(i));
		}
		return "yes";
	}
	
	@GetMapping("/proyectos/{id}")
	public String mostrarProyecto(Model model, @PathVariable("id") String idProyecto) {
		Proyecto proyecto = iProyectoSvc.findById(idProyecto);
		model.addAttribute("proy", proyecto);
		model.addAttribute("listaProyProds", iProductoSvc.findProyProdsByProyecto(proyecto));
		return "jefe/detalleProyecto";
	}
	
	@GetMapping("/proyectos/{id}/desasignarEmpleado")
	public String desasignar(@PathVariable("id") String idProyecto,
			@RequestParam("numeroOrden") int numeroOrden) {
		iProyectoSvc.desasignarEmpleado(numeroOrden);
		return "redirect:/jefe/proyectos/"+idProyecto;
	}
	
	@GetMapping("/proyectos/{id}/desasignarProducto")
	public String desasignarProducto(@PathVariable("id") String idProyecto,
			@RequestParam("numeroOrden") int numeroOrden) {
		iProductoSvc.desasignarProducto(numeroOrden);
		return "redirect:/jefe/proyectos/"+idProyecto;
	}
	
	@GetMapping("/asignarEmpleados")
	public String mostrarAsignarEmpleados(Model model, HttpSession sesion, @RequestParam(value = "idProyecto", required=false) String idProyecto) {
		Empleado jefe = (Empleado) sesion.getAttribute("empl");
		model.addAttribute("listaProyectos", iProyectoSvc.findByJefe(jefe));
		model.addAttribute("listaOperativos", iEmpleadoSvc.findByPerfil(3));
		if(idProyecto != null) model.addAttribute("idProyecto", idProyecto);
		return "/jefe/asignarEmpleados";
	}
	
	@PostMapping("/asignarEmpleados")
	public String asignarEmpleados(Model model, HttpSession sesion, RedirectAttributes attr,
			ProyectoConEmpleado proyEmp) {
		if (iProyectoSvc.asignarEmpleado(proyEmp) == 1) {
			attr.addFlashAttribute("mensajeExito", "Empleado asignado con exito");
			String idProyecto = proyEmp.getProyecto().getIdProyecto();
			return "redirect:/jefe/proyectos/"+idProyecto;
		}
		else {
			attr.addFlashAttribute("mensajeError", "No se ha podido asignar el empleado");
			return "redirect:/jefe/asignarEmpleados";
		}
	}
	
	@GetMapping("asignarProductos")
	public String mostrarAsignarProductos(Model model, HttpSession sesion, @RequestParam(value = "idProyecto", required=false) String idProyecto) {
		Empleado jefe = (Empleado) sesion.getAttribute("empl");
		model.addAttribute("listaProyectos", iProyectoSvc.findByJefe(jefe));
		model.addAttribute("listaProductos", iProductoSvc.fetchAll());
		if(idProyecto != null) model.addAttribute("idProyecto", idProyecto);
		return "jefe/asignarProductos";
	} 
	
	@PostMapping("/asignarProductos")
	public String asignarProductos(Model model, HttpSession sesion, RedirectAttributes attr,
			ProyectoConProducto proyProd) {
		if (iProductoSvc.asignarProducto(proyProd) == 1) {
			attr.addFlashAttribute("mensajeExito", "Producto asignado con exito");
			String idProyecto = proyProd.getProyecto().getIdProyecto();
			return "redirect:/jefe/proyectos/"+idProyecto;
		}
		else {
			attr.addFlashAttribute("mensajeError", "No se ha podido asignar el producto");
			return "redirect:/jefe/asignarProductos";
		}
		
		
	}

}
