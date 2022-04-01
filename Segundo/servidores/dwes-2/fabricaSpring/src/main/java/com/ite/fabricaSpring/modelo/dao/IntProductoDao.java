package com.ite.fabricaSpring.modelo.dao;

import java.util.List;

import com.ite.fabricaSpring.modelo.beans.Producto;

public interface IntProductoDao {
	List<Producto> findAll();
	Producto findById(int idProducto);
	List<Producto> findByFamilia(int idFamilia);
	int insertOne(Producto producto);
	int update(Producto producto);
	int eliminarProducto(int idProducto);
}
