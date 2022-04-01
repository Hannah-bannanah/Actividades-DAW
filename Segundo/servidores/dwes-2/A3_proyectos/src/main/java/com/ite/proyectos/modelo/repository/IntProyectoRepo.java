package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;

public interface IntProyectoRepo {
	List<Proyecto> fetchAll();
	Proyecto findById(String idProy);
	int crearProyecto(Proyecto proyecto);
	List<Proyecto> findByJefe(Empleado jefe);
	int asignarEmpleado(ProyectoConEmpleado proyEmp);
	int desasignarEmpleado(ProyectoConEmpleado proyEmp);
	Proyecto terminar(Proyecto proyecto, Date fechaFinReal, BigDecimal costeReal);
}
