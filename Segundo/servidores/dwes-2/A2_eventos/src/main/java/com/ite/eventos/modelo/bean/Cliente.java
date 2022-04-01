/**
 * 
 */
package com.ite.eventos.modelo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author hannah bannanah
 *
 */
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;
	private static int ultimoId = 0;
	
	private int idCliente;
	private String username;
	private String password;
	private String email;
	private String nombre;
	private String direccion;
	private int enabled;
	private Date fechaRegistro;
	
	
	/**
	 * Constructor vacio
	 */
	public Cliente() {
		super();
		this.idCliente = ++Cliente.ultimoId;
	}


	/**
	 * @param idCliente
	 * @param username
	 * @param password
	 * @param email
	 * @param nombre
	 * @param direccion
	 * @param enabled
	 * @param fechaRegistro
	 */
	public Cliente(String userName, String password, String email, String nombre, String direccion,
			int enabled, Date fechaRegistro) {
		super();
		this.idCliente = ++Cliente.ultimoId;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.direccion = direccion;
		this.enabled = enabled;
		this.fechaRegistro = fechaRegistro;
	}


	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}


	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idUsuario) {
		this.idCliente = idUsuario;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}


	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
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
		return idCliente == other.idCliente;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", username=" + username + ", password=" + password + ", email="
				+ email + ", nombre=" + nombre + ", direccion=" + direccion + ", enabled=" + enabled
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
}
