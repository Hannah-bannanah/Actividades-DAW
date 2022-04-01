package com.ite.cpe.modelo.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ite.cpe.modelo.beans.Proyecto;
import com.ite.cpe.modelo.beans.ProyectoConEmpleado;
import com.ite.cpe.modelo.beans.ProyectoConProducto;
import com.ite.cpe.modelo.repository.IntProyectoConEmpleadoRepo;
import com.ite.cpe.modelo.repository.IntProyectoConProductoRepo;
import com.ite.cpe.modelo.repository.IntProyectoRepo;
import org.springframework.stereotype.Service;

@Service
public class ProyectoDaoImpl implements IntProyectoDao{
	@Autowired
	IntProyectoRepo pyRepo;
	@Autowired
	IntProyectoConProductoRepo ppRepo;
	@Autowired
	IntProyectoConEmpleadoRepo peRepo;

	@Override
	public List<Proyecto> fetchAll() {
		return pyRepo.findAll();
	}
	
	@Override
	public Proyecto findById(String idProyecto) {
		Proyecto proyecto = null;
		try {
			proyecto = pyRepo.getById(idProyecto);
			proyecto.getDescripcion();
			return proyecto;
		} catch (EntityNotFoundException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int insertOne(Proyecto proyecto) {
		int filas = 0;
		if (findById(proyecto.getIdProyecto()) != null) return 0;
		try {
			pyRepo.save(proyecto);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Proyecto> findByJefe(int idJefe) {
		return pyRepo.findByJefe(idJefe);
	}

	@Override
	public int asignarProducto(ProyectoConProducto proyProd) {
		int filas = 0;
		Proyecto proyectoExistente = findById(proyProd.getProyecto().getIdProyecto());
		if (proyectoExistente == null) return 0;
		try {
			ppRepo.save(proyProd);
			proyectoExistente.addProyectoConProducto(proyProd);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int desasignarProducto(int numOrden) {
		int filas = 0;
		try {
			ProyectoConProducto proyProd = ppRepo.getById(numOrden);
			Proyecto proyecto = proyProd.getProyecto();
			ppRepo.deleteById(numOrden);
			proyecto.removeProyectoConProducto(proyProd);
			filas = 1;
		} catch (EntityNotFoundException e) {
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	@Override
	public int asignarEmpleado(ProyectoConEmpleado proyEmp) {
		int filas = 0;
		Proyecto proyectoExistente = findById(proyEmp.getProyecto().getIdProyecto());
		if (proyectoExistente == null) return 0;
		try {
			peRepo.save(proyEmp);
			proyectoExistente.addProyectoConEmpleado(proyEmp);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int desasignarEmpleado(int numOrden) {
		int filas = 0;
		try {
			ProyectoConEmpleado proyEmp = peRepo.getById(numOrden);
			Proyecto proyecto = proyEmp.getProyecto();
			peRepo.deleteById(numOrden);
			proyecto.removeProyectoConEmpleado(proyEmp);
			filas = 1;
		} catch (EntityNotFoundException e) {
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	
}
