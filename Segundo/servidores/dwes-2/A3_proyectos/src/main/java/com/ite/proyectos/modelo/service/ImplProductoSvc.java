package com.ite.proyectos.modelo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;
import com.ite.proyectos.modelo.repository.IntProductoRepo;
import com.ite.proyectos.modelo.repository.IntProyectoProductoRepo;
import com.ite.proyectos.modelo.repository.IntProyectoRepo;

@Service
public class ImplProductoSvc implements IntProductoSvc {
	@Autowired
	IntProductoRepo iProductos;
	@Autowired
	IntProyectoProductoRepo iProyProds;

	@Override
	public List<Producto> fetchAll() {
		return iProductos.fetchAll();
	}

	@Override
	public List<ProyectoConProducto> findProyProdsByProyecto(Proyecto proyecto) {
		List<ProyectoConProducto> productosProyecto = new ArrayList<ProyectoConProducto>();
		List<ProyectoConProducto> proyProds = iProyProds.fetchAll();
		for (ProyectoConProducto proyProd: proyProds) {
			if (proyProd.getProyecto().equals(proyecto))
				productosProyecto.add(proyProd);
		}
		return productosProyecto;
	}

	@Override
	public int altaProducto(Producto producto) {
		return iProductos.crearProducto(producto);
	}

	@Override
	public Producto findById(int idProducto) {
		return iProductos.findById(idProducto);
	}

	@Override
	public int asignarProducto(ProyectoConProducto proyProd) {
		return iProyProds.aniadirRegistro(proyProd);
	}

	@Override
	public int desasignarProducto(int numeroOrden) {
		ProyectoConProducto proyProd = iProyProds.findById(numeroOrden);
		if (iProductos.desasignarProducto(proyProd) != 1) return 0;
		return iProyProds.eliminarRegistro(proyProd);
	}
	
}
