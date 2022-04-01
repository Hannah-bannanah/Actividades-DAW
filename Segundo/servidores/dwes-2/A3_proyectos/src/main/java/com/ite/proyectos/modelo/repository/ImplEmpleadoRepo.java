package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Departamento;
import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.bean.Perfil;

/**
 * Implementacion del repositorio de empleados
 * @author hannah bannanah
 *
 */
@Repository
public class ImplEmpleadoRepo implements IntEmpleadoRepo{
	private List<Empleado> empleados;
	IntPerfilRepo iPerfiles;
	IntDepartamentoRepo iDepartamentos;
	
	/**
	 * Constructor del repostositorio
	 */
	public ImplEmpleadoRepo(IntPerfilRepo iPerf,IntDepartamentoRepo iDpto) {
		iPerfiles = iPerf;
		iDepartamentos = iDpto;
		empleados = new ArrayList<Empleado>();
		cargarDatos();
	}
	
	
	/**
	 * Funcion que carga una lista inicial de empleados
	 */
	private void cargarDatos() {
		System.out.println("cargando datos empleados");
		Calendar cal = Calendar.getInstance();
		Random rd = new Random();
		List<Perfil> perfiles = iPerfiles.fetchAll();
		List<Departamento> departamentos = iDepartamentos.fetchAll();
		for (int i=0; i < 20; i++) {
			int idEmpl = i + 100;
			String password = "user"+idEmpl;
			String correo = idEmpl + "@hannahEnterprises.edix";
			//generamos una fecha pseudoaleatoria para fechaInicio
			cal.set(2015 + rd.nextInt(7), rd.nextInt(13) + 1, rd.nextInt(29) + 1);
			Date fechaIngreso = cal.getTime();
			//generamos una fecha pseudoaleatoria para fechaEmpleado
			cal.set(1956 + rd.nextInt(48), rd.nextInt(13) + 1, rd.nextInt(29) + 1);
			Date fechaNacimiento = cal.getTime();
			String nombre = "Empleado"+ idEmpl;
			BigDecimal salario = new BigDecimal(35000 + rd.nextInt(70000));
			Departamento dpto = departamentos.get((int) i/5);
			dpto.setIdDepar(rd.nextInt(5) + 1);
			Perfil perfil = perfiles.get((int) i / 5);
			Empleado empleado = new Empleado(idEmpl, password, correo, fechaIngreso, fechaNacimiento, nombre, salario, dpto, perfil);
			//aniadimos jefe de departamento si no lo hay
			if (dpto.getJefeDepar() == null) {
				dpto.setJefeDepar(empleado);
			}
			empleados.add(empleado);
		}
		
	}
	
	private List<Empleado> findByIdPerfil(int idPerfil) {
		List<Empleado> empleadosConPerfil = new ArrayList<Empleado>();
		for (Empleado empleado: empleados) {
			if (empleado.getPerfil().getIdPerfil() == idPerfil)
				empleadosConPerfil.add(empleado);
		}
		return empleadosConPerfil;
	}

	/**
	 * Funcion que devuelve una lista de todos los empleados
	 * @return la lista de empleados
	 */
	@Override
	public List<Empleado> fetchAll() {
		return empleados;
	}

	@Override
	public List<Empleado> fetchJefes() {
		return findByIdPerfil(2);
	}

	@Override
	public Empleado findById(int idEmpl) {
		for (Empleado empleado: empleados) {
			if (empleado.getIdEmpl() == idEmpl)
				return empleado;
		}
		return null;
	}


	@Override
	public int crearEmpleado(Empleado empleado) {
		if (empleados.contains(empleado)) return 0;
		return empleados.add(empleado) ? 1 : 0;
	}


	@Override
	public int eliminarEmpleado(int idEmpl) {
		Empleado empleado = findById(idEmpl);
		if (empleado == null) return 0;
		return empleados.remove(empleado) ? 1 : 0;
	}
	

}
