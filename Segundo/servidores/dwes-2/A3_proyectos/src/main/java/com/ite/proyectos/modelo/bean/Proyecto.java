package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String idProyecto;

	
	private BigDecimal costeReal;

	
	private BigDecimal costesPrevisto;

	private String descripcion;

	private String estado;

	
	private Date fechaFinPrevisto;

	
	private Date fechaFinReal;

	
	private Date fechaInicio;

	
	private BigDecimal ventaPrevisto;

	
	private List<ProyectoConEmpleado> proyectoConEmpleados;

	
	private Cliente cliente;

	
	private Empleado jefeProyecto;

	public Proyecto() {
		this.costeReal = new BigDecimal(0);
		this.estado = "activo";
	}

	/**
	 * @param idProyecto
	 * @param costesPrevisto
	 * @param descripcion
	 * @param estado
	 * @param fechaFinPrevisto
	 * @param fechaInicio
	 * @param ventaPrevisto
	 * @param proyectoConEmpleados
	 * @param cliente
	 * @param jefeProyecto
	 */
	public Proyecto(String idProyecto, BigDecimal costesPrevisto, String descripcion,
			Date fechaFinPrevisto, Date fechaInicio, BigDecimal ventaPrevisto, Cliente cliente, Empleado jefeProyecto) {
		super();
		this.idProyecto = idProyecto;
		this.costesPrevisto = costesPrevisto;
		this.descripcion = descripcion;
		this.estado = "activo";
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaInicio = fechaInicio;
		this.ventaPrevisto = ventaPrevisto;
		this.cliente = cliente;
		this.jefeProyecto = jefeProyecto;
		this.fechaFinReal = null;
		this.costeReal = new BigDecimal(0);
	}
	
	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(BigDecimal ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public List<ProyectoConEmpleado> getProyectoConEmpleados() {
		if (proyectoConEmpleados == null) 
			proyectoConEmpleados = new ArrayList<ProyectoConEmpleado>();
		return this.proyectoConEmpleados;
	}

	public void setProyectoConEmpleados(List<ProyectoConEmpleado> proyectoConEmpleados) {
		this.proyectoConEmpleados = proyectoConEmpleados;
	}

	public ProyectoConEmpleado addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		if (proyectoConEmpleados == null) 
			proyectoConEmpleados = new ArrayList<ProyectoConEmpleado>();
		getProyectoConEmpleados().add(proyectoConEmpleado);
//		proyectoConEmpleado.setProyecto(this);

		return proyectoConEmpleado;
	}

	public ProyectoConEmpleado removeProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		if (proyectoConEmpleados == null) 
			proyectoConEmpleados = new ArrayList<ProyectoConEmpleado>();
		getProyectoConEmpleados().remove(proyectoConEmpleado);

		return proyectoConEmpleado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getJefeProyecto() {
		return this.jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProyecto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(idProyecto, other.idProyecto);
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", costeReal=" + costeReal + ", costesPrevisto=" + costesPrevisto
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", fechaFinPrevisto=" + fechaFinPrevisto
				+ ", fechaFinReal=" + fechaFinReal + ", fechaInicio=" + fechaInicio + ", ventaPrevisto=" + ventaPrevisto
				+ ", cliente=" + cliente + ", jefeProyecto=" + jefeProyecto + "]";
	}

}