package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.Empleado;

public interface IntEmpleadoRepo {
	List<Empleado> fetchAll();
	Empleado findById(int idEmpl);
	List<Empleado> fetchJefes();	
	int crearEmpleado(Empleado empleado);
	int eliminarEmpleado(int idEmpl);
}
