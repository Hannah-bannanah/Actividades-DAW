package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;
import com.ite.proyectos.modelo.service.IntEmpleadoSvc;

@Repository
public class ImplProyectoEmpleadoRepo implements IntProyectoEmpleadoRepo{
	private IntProyectoRepo iProyectos;
	private IntEmpleadoRepo iEmpleados;
	private List<ProyectoConEmpleado> proyEmps;
	
	public ImplProyectoEmpleadoRepo(IntProyectoRepo iProy, IntEmpleadoRepo iEmpl) {
		iProyectos = iProy;
		iEmpleados = iEmpl;
		proyEmps = new ArrayList<ProyectoConEmpleado>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("cargando datos proyEmp");
		List<Proyecto> proyectos = iProyectos.fetchAll();
		List<Empleado> empleados = iEmpleados.fetchAll();
		Random rd = new Random();
		Calendar cal = Calendar.getInstance();
		
		//asignamos un empleado a cada proyecto (quedan 10 empleados sin asignar)
		for (int i= 0; i < proyectos.size(); i++) {
			Proyecto proy = proyectos.get(i);
			Empleado empl = empleados.get(((int) i/2) + 10);
			int horasAsignadas = rd.nextInt(40) + 40;
			
			//aniadimos al empleado unos dias despues de la creacion del proyecto
			cal.setTime(proy.getFechaInicio());
			cal.add(Calendar.DAY_OF_MONTH, rd.nextInt(6) + 2);
			Date fechaIncorporacion = cal.getTime();
			
			ProyectoConEmpleado proyEmp = new ProyectoConEmpleado(fechaIncorporacion, horasAsignadas, empl, proy);
			proyEmps.add(proyEmp);
			proy.addProyectoConEmpleado(proyEmp);
		}
	}

	@Override
	public List<ProyectoConEmpleado> fetchAll() {
		return proyEmps;
	}

	@Override
	public List<ProyectoConEmpleado> findByIdProy(String idProy) {
		List<ProyectoConEmpleado> proyEmpsBuscados = new ArrayList<ProyectoConEmpleado>();
		for (ProyectoConEmpleado proyEmp : proyEmps) {
			if (proyEmp.getProyecto().getIdProyecto().equals(idProy))
				proyEmpsBuscados.add(proyEmp);
		}
		return proyEmpsBuscados;
	}

	@Override
	public ProyectoConEmpleado findById(int numeroOrden) {
		for (ProyectoConEmpleado proyEmp: proyEmps) {
			if (proyEmp.getNumeroOrden() == numeroOrden)
				return proyEmp;
		}
		return null;
	}

	@Override
	public int aniadirRegistro(ProyectoConEmpleado proyEmp) {
		if (iProyectos.asignarEmpleado(proyEmp) != 1) return 0;
		return proyEmps.add(proyEmp) ? 1 : 0;
	}
	
}
