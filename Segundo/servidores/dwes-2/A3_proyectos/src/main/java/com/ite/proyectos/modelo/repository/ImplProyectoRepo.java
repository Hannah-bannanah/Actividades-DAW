package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Cliente;
import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;

@Repository
public class ImplProyectoRepo implements IntProyectoRepo{
	private IntEmpleadoRepo iEmpleados;
	private IntClienteRepo iClientes;
	private List<Proyecto> proyectos;
	
	public ImplProyectoRepo(IntEmpleadoRepo iEmp, IntClienteRepo iCli) {
		iEmpleados = iEmp;
		iClientes = iCli;
		proyectos = new ArrayList<Proyecto>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("cargando datos proyecto");
		Random rd = new Random();
		Calendar cal = Calendar.getInstance();
		List<Empleado> jefesP = iEmpleados.fetchJefes();
		List<Cliente> clientes = iClientes.fetchAll();
		for (int i=0; i< 10; i++) {
			String idProyecto = "P" + (i + 100);
			BigDecimal costesPrevisto = new BigDecimal(rd.nextInt(38000) + 2000);
			String descripcion = "este es un proyecto con id " + idProyecto;
			//generamos una fecha pseudoaleatoria para fechaInicio
			cal.set(2018 + rd.nextInt(4), rd.nextInt(13) + 1, rd.nextInt(29) + 1);
			Date fechaInicio = cal.getTime();
			//generamos una fecha pseudoaleatoria para fechaFinPrevisto
			cal.add(Calendar.MONTH, rd.nextInt(19) + 6);
			Date fechaFinPrevisto = cal.getTime(); //esta fecha puede ser pasada, pero siempre mayor que la fechaInicio
			BigDecimal ventaPrevisto = (new BigDecimal(rd.nextInt(3) + 3)).multiply(costesPrevisto);
			Cliente cliente = clientes.get(i);
			Empleado jefe = jefesP.get((int) i/3);
			
			Proyecto proyecto = new Proyecto(idProyecto, costesPrevisto, descripcion, fechaFinPrevisto, fechaInicio, ventaPrevisto, cliente, jefe);
			proyectos.add(proyecto);
		}
	}
	@Override
	public List<Proyecto> fetchAll() {
		return proyectos;
	}

	@Override
	public Proyecto findById(String idProy) {
		for (Proyecto proyecto: proyectos) {
			if (proyecto.getIdProyecto().equals(idProy))
				return proyecto;
		}
		return null;
	}

	@Override
	public int crearProyecto(Proyecto proyecto) {
		if (proyectos.contains(proyecto)) return 0;
		return proyectos.add(proyecto) ? 1 : 0;
	}

	@Override
	public List<Proyecto> findByJefe(Empleado jefe) {
		List<Proyecto> proyectosConJefe = new ArrayList<Proyecto>();
		for (Proyecto proy: proyectos) {
			if (proy.getJefeProyecto().equals(jefe))
				proyectosConJefe.add(proy);
		}
		return proyectosConJefe;
	}

	@Override
	public int asignarEmpleado(ProyectoConEmpleado proyEmp) {
		Proyecto proyecto = proyEmp.getProyecto();
		for (ProyectoConEmpleado pE : proyecto.getProyectoConEmpleados()) {
			if (pE.getEmpleado().equals(proyEmp.getEmpleado())) return 0;
		}
		return proyecto.addProyectoConEmpleado(proyEmp) != null ? 1 : 0;
	}
	
	@Override
	public int desasignarEmpleado(ProyectoConEmpleado proyEmp) {
		Proyecto proyecto = proyEmp.getProyecto();
		return proyecto.removeProyectoConEmpleado(proyEmp) != null ? 1 : 0;
	}

	@Override
	public Proyecto terminar(Proyecto proyecto, Date fechaFinReal, BigDecimal costeReal) {
		proyecto.setFechaFinReal(fechaFinReal);
		proyecto.setEstado("terminado");
		proyecto.setCosteReal(costeReal);
		return proyecto;
	}



}
