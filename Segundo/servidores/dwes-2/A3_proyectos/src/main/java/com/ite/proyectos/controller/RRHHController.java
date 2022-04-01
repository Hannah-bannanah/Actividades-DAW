package com.ite.proyectos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.ite.proyectos.modelo.bean.Departamento;
import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Perfil;
import com.ite.proyectos.modelo.repository.IntDepartamentoRepo;
import com.ite.proyectos.modelo.service.IntEmpleadoSvc;
import com.ite.proyectos.modelo.service.IntPerfilSvc;
import com.ite.proyectos.util.CustomDepartamentoEditor;
import com.ite.proyectos.util.CustomPerfilEditor;

@Controller
@RequestMapping("/rrhh")
public class RRHHController {
	@Autowired
	IntEmpleadoSvc iEmpleadoSvc;
	@Autowired
	IntPerfilSvc iPerfilSvc;
	@Autowired
	IntDepartamentoRepo iDepartamentos;
	@Autowired
	CustomDepartamentoEditor departamentoEditor;
	@Autowired
	CustomPerfilEditor perfilEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		wdb.registerCustomEditor(Departamento.class, departamentoEditor);
		wdb.registerCustomEditor(Perfil.class, perfilEditor);
	}
	
	@GetMapping("")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/empleados")
	public String mostrarEmpleados(Model model) {
		model.addAttribute("listaEmpleados", iEmpleadoSvc.fetchAll());
		return "/rrhh/empleados";
	}
	
	@GetMapping("/empleados/{id}")
	public String detalleEmpleado(@PathVariable("id") int idEmpl, Model model) {
		model.addAttribute("empleado", iEmpleadoSvc.findById(idEmpl));
		return "/rrhh/detalleEmpleado";
	}
	
	@GetMapping("/empleados/{id}/baja")
	public String bajaEmpleado(@PathVariable("id") int idEmpl, RedirectAttributes attr) {
		if (iEmpleadoSvc.bajaEmpleado(idEmpl) == 1) 
			attr.addFlashAttribute("mensajeExito", "El empleado se ha dado de baja con &eacute;xito");
		else
			attr.addFlashAttribute("mensajeError", "No se ha podido dar de baja al empleado");
		return "redirect:/rrhh/empleados";
	}
	
	@GetMapping("/altaEmpleado")
	public String mostrarAltaEmpleado(Model model) {
		model.addAttribute("listaPerfiles", iPerfilSvc.fetchAll());
		model.addAttribute("listaDepartamentos", iDepartamentos.fetchAll());
		return "/rrhh/altaEmpleado";
	}
	
	@PostMapping("/altaEmpleado")
	public String altaEmpleado(RedirectAttributes attr, Empleado empleado) {
		if (iEmpleadoSvc.altaEmpleado(empleado) == 1) {
			attr.addFlashAttribute("mensajeExito", "El empleado ha sido registrado con &eacute;xito");
			return "redirect:/rrhh/empleados";
		}
		else {
			attr.addFlashAttribute("mensajeError", "No se ha podido registrar el empleado");
			return "redirect:/rrhh/altaEmpleado";
		}
	}
}
