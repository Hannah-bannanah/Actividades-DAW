package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class ProyectoConProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numeroOrden;

	private int cantidad;

	private BigDecimal precioAsignado;

	private Producto producto;

	private Proyecto proyecto;

	private static int ultimoId = 0;
	public ProyectoConProducto() {
		this.numeroOrden = ++ultimoId;
	}

	/**
	 * @param numeroOrden
	 * @param cantidad
	 * @param precioAsignado
	 * @param producto
	 * @param proyecto
	 */
	public ProyectoConProducto(int cantidad, BigDecimal precioAsignado, Producto producto,
			Proyecto proyecto) {
		super();
		this.numeroOrden = ++ultimoId;
		this.cantidad = cantidad;
		this.precioAsignado = precioAsignado;
		this.producto = producto;
		this.proyecto = proyecto;
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioAsignado() {
		return this.precioAsignado;
	}

	public void setPrecioAsignado(BigDecimal precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(producto, proyecto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProyectoConProducto other = (ProyectoConProducto) obj;
		return Objects.equals(producto, other.producto) && Objects.equals(proyecto, other.proyecto);
	}

	@Override
	public String toString() {
		return "ProyectoConProducto [numeroOrden=" + numeroOrden + ", cantidad=" + cantidad + ", precioAsignado="
				+ precioAsignado + ", producto=" + producto + ", proyecto=" + proyecto + "]";
	}
}