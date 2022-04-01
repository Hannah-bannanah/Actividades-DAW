/**
 * 
 */
package com.ite.fabrica_jdbc.modelo.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * @author hannah
 *
 */
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String direccion;
	private String email;
	private int enabled;
	private Date fechaRegistro;
	private String nombre;
	private String password;
	
	public Usuario() {
		super();
	}

	public Usuario(String username, String direccion, String email, int enabled, Date fechaRegistro, String nombre,
			String password) {
		super();
		this.username = username;
		this.direccion = direccion;
		this.email = email;
		this.enabled = enabled;
		this.fechaRegistro = fechaRegistro;
		this.nombre = nombre;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 :
		username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", direccion=" + direccion + ", email=" + email + ", enabled="
				+ enabled + ", fechaRegistro=" + fechaRegistro + ", nombre=" + nombre + ", password=" + password + "]";
	}
	
}
