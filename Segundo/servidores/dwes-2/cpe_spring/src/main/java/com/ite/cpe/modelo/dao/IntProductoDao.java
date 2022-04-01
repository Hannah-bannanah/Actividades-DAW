package com.ite.cpe.modelo.dao;

import com.ite.cpe.modelo.beans.Producto;

import java.util.List;

public interface IntProductoDao {
	List<Producto> fetchAll();
	Producto findById(int idProducto);
	int insertOne(Producto producto);
}
