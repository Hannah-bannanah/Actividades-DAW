package com.ite.libreria_jmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.util.Carrito;
import com.ite.libreria_jmp.util.LineaCarrito;

/**
 * Servicio del carrito
 * @author hannah
 *
 */
@Service
public class CarritoSvc implements IntCarritoSvc{
	
	@Autowired private IntPedidoSvc pedSvc;
	
	private Carrito carrito;
	
	public CarritoSvc() {
	}
	
	public void crearCarrito() {
		this.carrito = new Carrito();
	}
		
	public List<LineaCarrito> getLineas() {
		return this.carrito.getLineas();
	}
	
	public boolean anadirLibro(Libro libro) {
		return this.carrito.anadirLibro(libro);
	}
	
	public boolean eliminarLibro(Libro libro) {
		return this.carrito.eliminarLibro(libro);
	}
	
	public boolean realizarPedido(Usuario usuario) {
		return pedSvc.realizarPedido(usuario, carrito.getLineas()) != 0;
	}

	@Override
	public boolean carritoIsNull() {
		return this.carrito == null;
	}
}
