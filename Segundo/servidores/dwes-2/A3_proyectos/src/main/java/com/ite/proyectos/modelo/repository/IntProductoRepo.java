package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;

public interface IntProductoRepo {
	List<Producto> fetchAll();
	Producto findById(int idProd);
	int crearProducto(Producto producto);
	int asignarProducto(ProyectoConProducto proyProd);
	int desasignarProducto(ProyectoConProducto proyProd);
}
