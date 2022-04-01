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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.cpe.modelo.beans.Empleado;
import com.ite.cpe.modelo.dao.IntDepartamentoDao;
import com.ite.cpe.modelo.dao.IntEmpleadoDao;
import com.ite.cpe.modelo.dao.IntPerfilDao;

@Controller
@RequestMapping("/rrhh")
public class RrhhController {
	@Autowired
	private IntEmpleadoDao eDao;
	@Autowired
	private IntPerfilDao pDao;
	@Autowired
	private IntDepartamentoDao dDao;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@GetMapping("")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/empleados")
	public String mostrarEmpleados(Model model) {
		model.addAttribute("listaEmpleados", eDao.fetchAll());
		return "rrhh/empleados";
	}
	
	@GetMapping("/empleados/{id}")
	public String mostrarEmpleado(@PathVariable("id") int idEmpl, Model model) {
		Empleado empleadoDetalle = eDao.findById(idEmpl);
		if (empleadoDetalle != null) {
			model.addAttribute("empleadoDetalle", empleadoDetalle);
			return "rrhh/detalleEmpleado";
		} else {
			return "redirect:/rrhh/empleados";
		}
	}
	
	@GetMapping("/altaEmpleado")
	public String getAltaEmpleado(Model model) {
		model.addAttribute("listaPerfiles", pDao.fetchAll());
		model.addAttribute("listaDepartamentos", dDao.fetchAll());
		return "rrhh/altaEmpleado";
	}
	
	@PostMapping("/altaEmpleado") 
	public String altaEmpleado(Empleado empleado, RedirectAttributes attr) {
		if (eDao.insertOne(empleado) == 1)
			attr.addFlashAttribute("mensajeExito", "Alta procesada con &eacute;xito");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido procesar el alta");
		return "redirect:/rrhh/empleados";
	}

	
	@GetMapping("/bajaEmpleado/{id}")
	public String bajaEmpleado(@PathVariable("id") int idEmpl, RedirectAttributes attr) {
		if (eDao.removeById(idEmpl) == 1) 
			attr.addFlashAttribute("mensajeExito", "Baja procesada con &eacute;xito");
		else
			attr.addFlashAttribute("mensajeError", "No se ha podido procesar la baja");
		return "redirect:/rrhh/empleados";
	}

}
