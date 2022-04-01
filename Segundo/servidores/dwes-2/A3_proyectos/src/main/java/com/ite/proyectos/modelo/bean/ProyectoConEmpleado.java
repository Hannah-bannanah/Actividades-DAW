package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class ProyectoConEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numeroOrden;

	private Date fechaIncorporacion;

	private int horasAsignadas;

	
	private Empleado empleado;

	private Proyecto proyecto;
	
	private static int ultimoId = 0;

	public ProyectoConEmpleado() {
	}

	/**
	 * @param numeroOrden
	 * @param fechaIncorporacion
	 * @param horasAsignadas
	 * @param empleado
	 * @param proyecto
	 */
	public ProyectoConEmpleado(Date fechaIncorporacion, int horasAsignadas, Empleado empleado,
			Proyecto proyecto) {
		super();
		this.numeroOrden = ++ultimoId;
		this.fechaIncorporacion = fechaIncorporacion;
		this.horasAsignadas = horasAsignadas;
		this.empleado = empleado;
		this.proyecto = proyecto;
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Date getFechaIncorporacion() {
		return this.fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public int getHorasAsignadas() {
		return this.horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProyectoConEmpleado other = (ProyectoConEmpleado) obj;
		return numeroOrden == other.numeroOrden;
	}

	@Override
	public String toString() {
		return "ProyectoConEmpleado [numeroOrden=" + numeroOrden + ", fechaIncorporacion=" + fechaIncorporacion
				+ ", horasAsignadas=" + horasAsignadas + ", empleado=" + empleado + ", proyecto=" + proyecto + "]";
	}

}