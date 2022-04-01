package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idProducto;

	
	private String descripcionBreve;

	
	private String descripcionLarga;

	
	private BigDecimal precioUnitario;

	private int stock;

	
	private List<ProyectoConProducto> proyectoConProductos;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	/**
	 * @param idProducto
	 * @param descripcionBreve
	 * @param descripcionLarga
	 * @param precioUnitario
	 * @param stock
	 * @param proyectoConProductos
	 */
	public Producto(int idProducto, String descripcionBreve, String descripcionLarga, BigDecimal precioUnitario,
			int stock) {
		super();
		this.idProducto = idProducto;
		this.descripcionBreve = descripcionBreve;
		this.descripcionLarga = descripcionLarga;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionBreve() {
		return this.descripcionBreve;
	}

	public void setDescripcionBreve(String descripcionBreve) {
		this.descripcionBreve = descripcionBreve;
	}

	public String getDescripcionLarga() {
		return this.descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ProyectoConProducto> getProyectoConProductos() {
		if (proyectoConProductos == null) {
			proyectoConProductos = new ArrayList<ProyectoConProducto>();
		}
		return this.proyectoConProductos;
	}

	public void setProyectoConProductos(List<ProyectoConProducto> proyectoConProductos) {
		this.proyectoConProductos = proyectoConProductos;
	}

	public ProyectoConProducto addProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		if (proyectoConProductos == null) {
			proyectoConProductos = new ArrayList<ProyectoConProducto>();
		}
		getProyectoConProductos().add(proyectoConProducto);
//		proyectoConProducto.setProducto(this);

		return proyectoConProducto;
	}

	public ProyectoConProducto removeProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		if (proyectoConProductos == null) {
			proyectoConProductos = new ArrayList<ProyectoConProducto>();
		}
		getProyectoConProductos().remove(proyectoConProducto);
//		proyectoConProducto.setProducto(null);

		return proyectoConProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcionBreve=" + descripcionBreve + ", descripcionLarga="
				+ descripcionLarga + ", precioUnitario=" + precioUnitario + ", stock=" + stock + "]";
	}

}