package com.ite.cpe.modelo.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ite.cpe.modelo.beans.Cliente;
import com.ite.cpe.modelo.beans.Empleado;
import com.ite.cpe.modelo.repository.IntEmpleadoRepo;

@Service
public class EmpleadoDaoImpl implements IntEmpleadoDao {
	
	@Autowired
	private IntEmpleadoRepo eRepo;

	@Override
	public Empleado validarUsuario(int idEmpleado, String correo, String password) {
			Empleado empleado = findById(idEmpleado);
			if (empleado != null && empleado.getCorreo().equals(correo) && empleado.getPassword().equals(password))
				return empleado;
			else return null;
	}

	@Override
	public List<Empleado> fetchAll() {
		return eRepo.findAll();
	}

	@Override
	public Empleado findById(int idEmpl) {
		Empleado empleado = null;
//		try {
//			empleado = eRepo.getById(idEmpl);
//			empleado.getCorreo(); //chapuza workaround porque la EntityNotFoundException solo salta al acceder a empleado, NO al llamar al metodo getById()
//			return empleado;
//		} catch(EntityNotFoundException e) {
//			return null;
//		} catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		return eRepo.findById(idEmpl).orElse(null);

	}

	@Override
	public int removeById(int idEmpl) {
		int filas = 0;
		try {
			eRepo.deleteById(idEmpl);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int insertOne(Empleado empleado) {
		if (findById(empleado.getIdEmpl()) != null) return 0;
		int filas = 0;
		try {
			eRepo.save(empleado);
			filas = 1;
		} catch (Exception e){
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Empleado> findByPerfil(int idPerfil) {
		return eRepo.findByPerfil(idPerfil);
	}

}
