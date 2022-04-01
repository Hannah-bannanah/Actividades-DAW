package com.ite.proyectos.modelo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the empleados database table.
 * 
 */
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idEmpl;

	private String password;
	
	private String correo;

	private Date fechaIngreso;

	private Date fechaNacimiento;

	private String nombre;

	private BigDecimal salario;

	private Departamento departamento;

	private Perfil perfil;

	public Empleado() {
	}

	/**
	 * @param idEmpl
	 * @param correo
	 * @param fechaIngreso
	 * @param fechaNacimiento
	 * @param nombre
	 * @param salario
	 * @param departamento
	 * @param perfil
	 */
	public Empleado(int idEmpl, String password, String correo, Date fechaIngreso, Date fechaNacimiento, String nombre,
			BigDecimal salario, Departamento departamento, Perfil perfil) {
		super();
		this.idEmpl = idEmpl;
		this.password = password;
		this.correo = correo;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
		this.perfil = perfil;
	}

	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEmpl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return idEmpl == other.idEmpl;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", correo=" + correo + ", fechaIngreso=" + fechaIngreso
				+ ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", salario=" + salario
				+ ", perfil=" + perfil + "]";
	}

}