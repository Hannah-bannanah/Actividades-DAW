package com.ite.proyectos.modelo.service;

import java.util.List;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;

public interface IntProyectoSvc {
	List<Proyecto> fetchAll();
	Proyecto findById(String idProy);
	int altaProyecto(Proyecto proyecto);
	List<Proyecto> findByJefe(Empleado jefe);
	int terminarProyecto(String idProyecto);
	int desasignarEmpleado(int idProyEmp);
	int asignarEmpleado(ProyectoConEmpleado proyEmp);
}
