package model.beans;

import java.io.Serializable;

/**
 * Clase que representa un Tipo de Evento
 * 
 * @author hannah
 *
 */
public class TipoEvento implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idTipo;
	private String nombre;
	private String descripcion;
	
	/**
	 * Constructor vacío
	 */
	public TipoEvento() {
		super();
	}

	/**
	 * Constructor con todos los campos
	 * 
	 * @param idTipo
	 * @param nombre
	 * @param descripcion
	 */
	public TipoEvento(int idTipo, String nombre, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * @return the idTipo
	 */
	public int getIdTipo() {
		return idTipo;
	}

	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TipoEvento))
			return false;
		TipoEvento other = (TipoEvento) obj;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoEvento [idTipo=" + idTipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}