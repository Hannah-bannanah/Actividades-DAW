package com.ite.proyectos.modelo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;
import com.ite.proyectos.modelo.repository.IntProyectoEmpleadoRepo;
import com.ite.proyectos.modelo.repository.IntProyectoRepo;

@Service
public class ImplProyectoSvc implements IntProyectoSvc{
	
	@Autowired
	IntProyectoRepo iProyectos;
	@Autowired
	IntProyectoEmpleadoRepo iProyEmps;
	@Autowired
	IntProductoSvc iProductoSvc;

	@Override
	public List<Proyecto> fetchAll() {
		return iProyectos.fetchAll();
	}

	@Override
	public Proyecto findById(String idProy) {
		return iProyectos.findById(idProy);
	}

	@Override
	public int altaProyecto(Proyecto proyecto) {
		return iProyectos.crearProyecto(proyecto);
	}

	@Override
	public List<Proyecto> findByJefe(Empleado jefe) {
		return iProyectos.findByJefe(jefe);
	}

	@Override
	public int terminarProyecto(String idProyecto) {
		Proyecto proyecto = iProyectos.findById(idProyecto);
				
		// Verificamos que hoy es posterior a la fecha de inicio
		// antes de actualizarla
		Date today = new Date();
		if (today.before(proyecto.getFechaInicio())) return 0;
		
		//Calculamos costes 
		BigDecimal costes = proyecto.getCosteReal();
		List<ProyectoConEmpleado> proyEmps = proyecto.getProyectoConEmpleados();
		for (ProyectoConEmpleado proyEmp: proyEmps)
			costes = costes.add(new BigDecimal(proyEmp.getHorasAsignadas() * 80));
		List<ProyectoConProducto> proyProds = iProductoSvc.findProyProdsByProyecto(proyecto);
		for (ProyectoConProducto proyProd: proyProds)
			costes = costes.add(proyProd.getPrecioAsignado().multiply(new BigDecimal(proyProd.getCantidad())));

		//terminamos el proyecto
		return iProyectos.terminar(proyecto, today, costes) != null ? 1 : 0;
	}

	@Override
	public int desasignarEmpleado(int idProyEmp) {
		ProyectoConEmpleado proyEmp = iProyEmps.findById(idProyEmp);
		return iProyectos.desasignarEmpleado(proyEmp);
	}

	@Override
	public int asignarEmpleado(ProyectoConEmpleado proyEmp) {		
		return iProyEmps.aniadirRegistro(proyEmp);
	}

	
}
