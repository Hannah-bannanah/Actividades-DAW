package model.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa un Evento
 * 
 * @author hannah
 *
 */
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;

	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private char destacado;
	private int maxAforo;
	private int minAsistencia;
	private double precio;
	private TipoEvento tipo;
	
	/**
	 * Constructor vacío
	 */
	public Evento() {
		super();
	}

	/**
	 * @param idEvento
	 * @param nombre
	 * @param descripcion
	 * @param fechaInicio
	 * @param duracion
	 * @param direccion
	 * @param estado
	 * @param destacado
	 * @param maxAforo
	 * @param minAsistencia
	 * @param precio
	 * @param tipo
	 */
	public Evento(int idEvento, String nombre, String descripcion, 
			Date fechaInicio, int duracion, String direccion,
			String estado, char destacado, int maxAforo, int minAsistencia, 
			double precio, TipoEvento tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.maxAforo = maxAforo;
		this.minAsistencia = minAsistencia;
		this.precio = precio;
		this.tipo = tipo;
	}

	/**
	 * @return the idEvento
	 */
	public int getIdEvento() {
		return idEvento;
	}

	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
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

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the destacado
	 */
	public char getDestacado() {
		return destacado;
	}

	/**
	 * @param destacado the destacado to set
	 */
	public void setDestacado(char destacado) {
		this.destacado = destacado;
	}

	/**
	 * @return the maxAforo
	 */
	public int getMaxAforo() {
		return maxAforo;
	}

	/**
	 * @param maxAforo the maxAforo to set
	 */
	public void setMaxAforo(int maxAforo) {
		this.maxAforo = maxAforo;
	}

	/**
	 * @return the minAsistencia
	 */
	public int getMinAsistencia() {
		return minAsistencia;
	}

	/**
	 * @param minAsistencia the minAsistencia to set
	 */
	public void setMinAsistencia(int minAsistencia) {
		this.minAsistencia = minAsistencia;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the tipo
	 */
	public TipoEvento getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (idEvento != other.idEvento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", maxAforo=" + maxAforo + ", minAsistencia=" + minAsistencia
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}
	

	

}
