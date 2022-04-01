package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;

public interface IntProyectoEmpleadoRepo {
	List<ProyectoConEmpleado> fetchAll();
	List<ProyectoConEmpleado> findByIdProy (String idProy);
	ProyectoConEmpleado findById(int numeroOrden);
	int aniadirRegistro(ProyectoConEmpleado proyEmp);
}
