package com.ite.proyectos.modelo.service;

import java.util.List;

import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;

public interface IntProductoSvc {
	List<Producto> fetchAll();
	Producto findById(int idProducto);
	List<ProyectoConProducto> findProyProdsByProyecto(Proyecto proyecto);
	int altaProducto(Producto producto);
	int asignarProducto(ProyectoConProducto proyProd);
	int desasignarProducto(int numeroOrden);
}
