package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;



public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String cif;

	private String domicilio;

	
	private BigDecimal facturacionAnual;

	private String nombre;

	private int numeroEmpleados;

	public Cliente() {
	}

	/**
	 * @param cif
	 * @param domicilio
	 * @param facturacionAnual
	 * @param nombre
	 * @param numeroEmpleados
	 */
	public Cliente(String cif, String domicilio, BigDecimal facturacionAnual, String nombre, int numeroEmpleados) {
		super();
		this.cif = cif;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.nombre = nombre;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public BigDecimal getFacturacionAnual() {
		return this.facturacionAnual;
	}

	public void setFacturacionAnual(BigDecimal facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", domicilio=" + domicilio + ", facturacionAnual=" + facturacionAnual
				+ ", nombre=" + nombre + ", numeroEmpleados=" + numeroEmpleados + "]";
	}
	

}