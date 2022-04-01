package com.ite.cpe.controller;

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

import com.ite.cpe.modelo.beans.Empleado;
import com.ite.cpe.modelo.beans.ProyectoConEmpleado;
import com.ite.cpe.modelo.beans.ProyectoConProducto;
import com.ite.cpe.modelo.dao.IntEmpleadoDao;
import com.ite.cpe.modelo.dao.IntProductoDao;
import com.ite.cpe.modelo.dao.IntProyectoDao;

@Controller
@RequestMapping("/jefe")
public class JefeController {

	@Autowired
	IntProyectoDao pyDao; 
	
	@Autowired
	IntProductoDao pdDao;
	
	@Autowired
	IntEmpleadoDao eDao;
	
	@GetMapping("/proyectos")
	public String mostrarProyectos(Model model, HttpSession sesion) {
		Empleado jefe = (Empleado) sesion.getAttribute("empleado");
		model.addAttribute("listaProyectos", pyDao.findByJefe(jefe.getIdEmpl()));
		return "proyectos";
	}
	
	@GetMapping("/proyectos/{id}")
	public String mostrarProyecto(@PathVariable("id") String idProyecto, Model model) {
		model.addAttribute("proyecto", pyDao.findById(idProyecto));
		return "jefe/detalleProyecto";
	}
	
	@GetMapping("/asignarProductos")
	public String getAsignarProductos(Model model, HttpSession sesion,
			@RequestParam(value = "idProyecto", required=false) String idProyecto) {
		if (idProyecto != null) 
			model.addAttribute("idProyecto", idProyecto);
		Empleado jefe = (Empleado) sesion.getAttribute("empleado");
		model.addAttribute("listaProyectos", pyDao.findByJefe(jefe.getIdEmpl()));
		model.addAttribute("listaProductos", pdDao.fetchAll());
		return "jefe/asignarProductos";
	}
	
	@PostMapping("/asignarProductos")
	public String asignarProducto(ProyectoConProducto proyProd, RedirectAttributes attr) {
		if (pyDao.asignarProducto(proyProd) == 1) {
			attr.addFlashAttribute("mensajeExito", "Producto a&ntilde;adido con &eacute;xito");
			return "redirect:/jefe/proyectos/"+proyProd.getProyecto().getIdProyecto();
		}
		else {
			attr.addFlashAttribute("mensajeError", "No se ha podido a&ntilde;adir el producto");
			return "redirect:/jefe/asignarProductos"+proyProd.getProyecto().getIdProyecto();
		}
	}
	
	@GetMapping("/proyectos/{id}/desasignarProducto")
	public String deasingarProducto(@RequestParam("numeroOrden") int numeroOrden,
			RedirectAttributes attr, @PathVariable("id") String idProyecto) {
		if (pyDao.desasignarProducto(numeroOrden) == 1) 
			attr.addFlashAttribute("mensajeExito", "Producto eliminado del proyecto");
		else
			attr.addFlashAttribute("mensajeError", "No se ha podido desasignar el producto");
		return "redirect:/jefe/proyectos/" + idProyecto;
	}
	
	@GetMapping("/asignarEmpleados")
	public String getAsignarEmpleados(Model model, HttpSession sesion,
			@RequestParam(value = "idProyecto", required=false) String idProyecto) {
		if (idProyecto != null)
			model.addAttribute("idProyecto", idProyecto);
		Empleado jefe = (Empleado) sesion.getAttribute("empleado");
		model.addAttribute("listaProyectos", pyDao.findByJefe(jefe.getIdEmpl()));
		model.addAttribute("listaOperativos", eDao.findByPerfil(3));
		return "jefe/asignarEmpleados";
	}
	
	@PostMapping("/asignarEmpleados")
	public String asignarEmpleado(ProyectoConEmpleado proyEmp, RedirectAttributes attr) {
		if (pyDao.asignarEmpleado(proyEmp) == 1) {
			attr.addFlashAttribute("mensajeExito", "El empleado se ha asignado con &eacute;xito");
			return "redirect:/jefe/proyectos/"+proyEmp.getProyecto().getIdProyecto();
		} else {
			attr.addFlashAttribute("mensajeError", "No se ha podido asignar al empleado");
			return "redirect:/jefe/asignarEmpleados"+proyEmp.getProyecto().getIdProyecto();
		}
	}
	
	@GetMapping("/proyectos/{id}/desasignarEmpleado")
	public String desasignarEmpleado(@PathVariable("id") String idProyecto,
			@RequestParam("numeroOrden") int numeroOrden, RedirectAttributes attr) {
		if (pyDao.desasignarEmpleado(numeroOrden) == 1)
			attr.addFlashAttribute("mensajeExito", "El empleado se ha desasignado del proyecto");
		else
			attr.addFlashAttribute("mensajeError", "No se ha podido desasignar el empleado");
		return "redirect:/jefe/proyectos/" + idProyecto;
	}
}
