package com.ite.cpe.modelo.dao;

import java.util.List;

import com.ite.cpe.modelo.beans.Proyecto;
import com.ite.cpe.modelo.beans.ProyectoConEmpleado;
import com.ite.cpe.modelo.beans.ProyectoConProducto;

public interface IntProyectoDao {
	List<Proyecto> fetchAll();
	Proyecto findById(String idProyecto);
	int insertOne(Proyecto proyecto);
	List<Proyecto> findByJefe(int idJefe);
	int asignarProducto(ProyectoConProducto proyProd);
	int desasignarProducto(int numOrden);
	int asignarEmpleado(ProyectoConEmpleado proyEmo);
	int desasignarEmpleado(int numOrden);
}
