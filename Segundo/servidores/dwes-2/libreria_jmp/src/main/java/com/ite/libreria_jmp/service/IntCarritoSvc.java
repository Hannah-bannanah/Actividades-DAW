package com.ite.libreria_jmp.service;

import java.util.List;

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.util.LineaCarrito;

public interface IntCarritoSvc {
	void crearCarrito();
	List<LineaCarrito> getLineas();
	boolean anadirLibro(Libro libro);
	boolean eliminarLibro(Libro libro);
	boolean realizarPedido(Usuario usuario);
	boolean carritoIsNull();
}
