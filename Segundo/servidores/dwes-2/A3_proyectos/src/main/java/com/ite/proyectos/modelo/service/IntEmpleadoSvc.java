package com.ite.proyectos.modelo.service;

import java.util.List;

import com.ite.proyectos.modelo.bean.Empleado;

public interface IntEmpleadoSvc {
	List<Empleado> fetchAll();
	List<Empleado> fetchJefes();
	Empleado findById(int idEmpleado);
	Empleado validarUsuario(int idEmpl, String correo, String password);
	List<Empleado> findByPerfil(int idPerfil);
	int altaEmpleado(Empleado empleado);
	int bajaEmpleado(int idEmpl);
}
