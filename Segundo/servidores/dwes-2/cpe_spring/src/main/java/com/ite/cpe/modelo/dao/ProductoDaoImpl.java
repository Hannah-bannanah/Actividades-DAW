package com.ite.cpe.modelo.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.cpe.modelo.beans.Producto;
import com.ite.cpe.modelo.repository.IntProductoRepo;

@Service
public class ProductoDaoImpl implements IntProductoDao {

	@Autowired
	IntProductoRepo pdRepo;

	@Override
	public List<Producto> fetchAll() {
		return pdRepo.findAll();
	}

	@Override
	public Producto findById(int idProducto) {
		try {
			Producto producto = pdRepo.getById(idProducto);
			producto.getDescripcionBreve();
			return producto;
		} catch (EntityNotFoundException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertOne(Producto producto) {
		int filas = 0;
		if (findById(producto.getIdProducto()) != null) return 0;
		try {
			pdRepo.save(producto);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
