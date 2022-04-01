package com.ite.libreria_jmp.util;

import com.ite.libreria_jmp.model.beans.Libro;

/**
 * Clase que representa una linea de carrito.
 * Contiene un libro y una cantidad
 * @author hannah
 * @see Carrito
 */
public class LineaCarrito {
	private Libro libro;
	private int cantidad;
	
	public LineaCarrito(Libro libro) {
		this.libro = libro;
		this.cantidad = 1;
	}

	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
