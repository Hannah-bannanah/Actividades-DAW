package com.ite.fabricaSpring.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fabricaSpring.modelo.beans.Producto;
import com.ite.fabricaSpring.modelo.repository.IntProductoRepo;

@Service
public class ProductoDaoImpl implements IntProductoDao {

	@Autowired
	private IntProductoRepo prepo;

	@Override
	public List<Producto> findAll() {
		return prepo.findAll();
	}

	@Override
	public Producto findById(int idProducto) {
		return prepo.getById(idProducto);
	}

	@Override
	public List<Producto> findByFamilia(int idFamilia) {
		return prepo.findByFamilia(idFamilia);
	}

	@Override
	public int insertOne(Producto producto) {
		int filas = 0;
		try {
			prepo.save(producto);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	@Override
	public int update(Producto producto) {
		int filas = 0;
		
		if(prepo.getById(producto.getIdProducto()) == null) return 0;
		try {
			prepo.save(producto);
			filas = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}

	@Override
	public int eliminarProducto(int idProducto) {
		int filas = 0;
		try {
			prepo.deleteById(idProducto);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
