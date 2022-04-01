package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.util.Objects;



public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDepar;

	private String direccion;

	private String nombre;
	
	private Empleado jefeDepar;

	public Departamento() {
	}

	/**
	 * @param idDepar
	 * @param direccion
	 * @param nombre
	 * @param jefeDepar
	 */
	public Departamento(int idDepar, String direccion, String nombre, Empleado jefeDepar) {
		super();
		this.idDepar = idDepar;
		this.direccion = direccion;
		this.nombre = nombre;
		this.jefeDepar = jefeDepar;
	}

	public int getIdDepar() {
		return this.idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getJefeDepar() {
		return this.jefeDepar;
	}

	public void setJefeDepar(Empleado jefeDepar) {
		this.jefeDepar = jefeDepar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return idDepar == other.idDepar;
	}

	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", direccion=" + direccion + ", nombre=" + nombre;
	}

}