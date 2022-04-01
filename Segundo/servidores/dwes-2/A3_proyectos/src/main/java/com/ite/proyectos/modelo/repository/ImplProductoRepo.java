package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Producto;
import com.ite.proyectos.modelo.bean.Proyecto;
import com.ite.proyectos.modelo.bean.ProyectoConEmpleado;
import com.ite.proyectos.modelo.bean.ProyectoConProducto;

@Repository
public class ImplProductoRepo implements IntProductoRepo{
	private List<Producto> productos;
	public ImplProductoRepo() {
		productos = new ArrayList<Producto>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("cargando datos producto");
		Random rd = new Random();
		for (int i = 0; i< 20; i++) {
			int idProducto = 100 + i;
			String descripcionBreve = "Prod #" + idProducto;
			String descripcionLarga = "Era un maravilloso dia de otronio, y andaba yo con prod " + idProducto;
			BigDecimal precioUnitario = new BigDecimal(0.01 * (rd.nextInt(200) + 30));
			int stock = rd.nextInt(60);
			Producto producto = new Producto(idProducto, descripcionBreve, descripcionLarga, precioUnitario, stock);
			productos.add(producto);
		}
	}
	
	@Override
	public List<Producto> fetchAll() {
		return productos;
	}
	@Override
	public Producto findById(int idProducto) {
		for (Producto producto: productos) {
			if (producto.getIdProducto() == idProducto)
				return producto;
		}
		return null;
	}

	@Override
	public int crearProducto(Producto producto) {
		System.out.println("producto:" + producto);
		if (productos.contains(producto)) return 0;
		return productos.add(producto) ? 1 : 0;
	}


	@Override
	public int asignarProducto(ProyectoConProducto proyProd) {
		Producto producto = proyProd.getProducto();
		for (ProyectoConProducto pP : producto.getProyectoConProductos()) {
			if (pP.getProyecto().equals(proyProd.getProyecto())) return 0;
		}
		return producto.addProyectoConProducto(proyProd) != null ? 1 : 0;
	}

	@Override
	public int desasignarProducto(ProyectoConProducto proyProd) {
		Producto producto = proyProd.getProducto();
		return producto.removeProyectoConProducto(proyProd) != null ? 1 : 0;
	}
}
