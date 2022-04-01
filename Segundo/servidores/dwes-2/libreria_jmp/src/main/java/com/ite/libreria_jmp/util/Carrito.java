package com.ite.libreria_jmp.util;

import java.util.ArrayList;
import java.util.List;

import com.ite.libreria_jmp.model.beans.Libro;

/**
 * Clase que representa un Carrito de un cliente
 * Contiene una serie de {@link LineaCarrito} 
 * @author hannah
 * @see LineaCarrito
 */
public class Carrito {
	private List<LineaCarrito> lineas;
	
	public Carrito() {
		this.lineas = new ArrayList<LineaCarrito>();
	}
	
	/**
	 * @return the lineas
	 */
	public List<LineaCarrito> getLineas() {
		return lineas;
	}

	/**
	 * @param lineas the lineas to set
	 */
	public void setLineas(List<LineaCarrito> lineas) {
		this.lineas = lineas;
	}

	public boolean anadirLibro(Libro libro) {
		for (LineaCarrito linea: lineas) {
			if (linea.getLibro().equals(libro)) {
				linea.setCantidad(linea.getCantidad() + 1);
				return true;
			}
		}
		LineaCarrito nuevaLinea = new LineaCarrito(libro);
		return lineas.add(nuevaLinea);
	}
	
	public boolean eliminarLibro(Libro libro) {
		for (LineaCarrito linea: lineas) {
			if (linea.getLibro().equals(libro)) {
				return lineas.remove(linea);
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Carrito [lineas=" + lineas + "]";
	}
	
	
}
