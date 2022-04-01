package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;

@Repository
public class ImplProyectoProductoRepo implements IntProyectoProductoRepo{
	private IntProyectoRepo iProyectos;
	private IntProductoRepo iProductos;
	List<ProyectoConProducto> proyProds;
	
	public ImplProyectoProductoRepo(IntProyectoRepo iProy, IntProductoRepo iProd) {
		iProyectos = iProy;
		iProductos = iProd;
		proyProds = new ArrayList<ProyectoConProducto>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("cargando datos proyProd");
		List<Proyecto> proyectos = iProyectos.fetchAll();
		List<Producto> productos = iProductos.fetchAll();
		Random rd = new Random();
		for(int i = 0; i< proyectos.size(); i++) {
			int cantidad = rd.nextInt(30) + 1;
			BigDecimal precioAsignado = new BigDecimal(rd.nextInt(20000) + 1000);
			precioAsignado = precioAsignado.divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
			Proyecto proyecto = proyectos.get(i);
			Producto producto1 = productos.get(i);
			Producto producto2 = productos.get(i + 10);
			ProyectoConProducto proyProd1 = new ProyectoConProducto(cantidad, precioAsignado, producto1, proyecto);
			ProyectoConProducto proyProd2 = new ProyectoConProducto(cantidad, precioAsignado, producto2, proyecto);
			proyProds.add(proyProd1);
			proyProds.add(proyProd2);
			producto1.addProyectoConProducto(proyProd1);
			producto2.addProyectoConProducto(proyProd2);
		}
	}

	@Override
	public List<ProyectoConProducto> fetchAll() {
		return proyProds;
	}

	@Override
	public int aniadirRegistro(ProyectoConProducto proyProd) {
		if (iProductos.asignarProducto(proyProd) != 1) return 0;
		return proyProds.add(proyProd) ? 1 : 0;
	}
	
	@Override
	public int eliminarRegistro(ProyectoConProducto proyProd) {
		return proyProds.remove(proyProd) ? 1 : 0;
	}
	
	@Override
	public ProyectoConProducto findById(int numeroOrden) {
		for (ProyectoConProducto proyProd : proyProds) {
			if (proyProd.getNumeroOrden() == numeroOrden)
				return proyProd;
		}
		return null;
	}


}
