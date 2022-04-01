package com.ite.cpe.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.cpe.modelo.beans.Cliente;
import com.ite.cpe.modelo.beans.Empleado;

public interface IntEmpleadoDao{
	Empleado validarUsuario(int idEmpleado, String correo, String password);
	List<Empleado> fetchAll();
	Empleado findById(int idEmpl);
	int removeById(int idEmpl);
	int insertOne(Empleado empleado);
	List<Empleado> findByPerfil(int idPerfil);
}
