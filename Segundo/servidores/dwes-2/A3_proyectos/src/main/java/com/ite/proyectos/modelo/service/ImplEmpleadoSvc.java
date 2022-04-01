package com.ite.proyectos.modelo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.repository.IntEmpleadoRepo;

@Service
public class ImplEmpleadoSvc implements IntEmpleadoSvc {
	@Autowired
	private IntEmpleadoRepo iEmpleados;

	@Override
	public List<Empleado> fetchAll() {
		return iEmpleados.fetchAll();
	}

	@Override
	public Empleado findById(int idEmpl) {
		return iEmpleados.findById(idEmpl);
	}

	@Override
	public Empleado validarUsuario(int idEmpl, String correo, String password) {
		for (Empleado empleado: iEmpleados.fetchAll()) {
			if (empleado.getIdEmpl() == idEmpl 
					&& empleado.getCorreo().equals(correo)
					&& empleado.getPassword().equals(password))
				return empleado;
		}
		return null;
	}

	@Override
	public List<Empleado> fetchJefes() {
		return iEmpleados.fetchJefes();
	}

	@Override
	public List<Empleado> findByPerfil(int idPerfil) {
		List<Empleado> empleadosPerfil = new ArrayList<Empleado>();
		for (Empleado empl: iEmpleados.fetchAll()) {
			if (empl.getPerfil().getIdPerfil() == idPerfil)
				empleadosPerfil.add(empl);
		}
		return empleadosPerfil;
	}

	@Override
	public int altaEmpleado(Empleado empleado) {
		return iEmpleados.crearEmpleado(empleado);
	}

	@Override
	public int bajaEmpleado(int idEmpl) {
		return iEmpleados.eliminarEmpleado(idEmpl);
	}
}
