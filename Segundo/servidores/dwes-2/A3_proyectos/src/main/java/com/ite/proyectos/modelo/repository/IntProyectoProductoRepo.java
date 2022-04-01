package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.ProyectoConProducto;

public interface IntProyectoProductoRepo {
	List<ProyectoConProducto> fetchAll();
	int aniadirRegistro(ProyectoConProducto proyProd);
	int eliminarRegistro(ProyectoConProducto proyProd);
	ProyectoConProducto findById(int numeroOrden);
}
