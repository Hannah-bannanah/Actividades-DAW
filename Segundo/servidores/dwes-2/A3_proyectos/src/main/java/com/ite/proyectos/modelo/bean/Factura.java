package com.ite.proyectos.modelo.bean;

import java.io.Serializable;


public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String idFactura;

	private String descripcion;

	
	private Proyecto proyecto;

	public Factura() {
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}