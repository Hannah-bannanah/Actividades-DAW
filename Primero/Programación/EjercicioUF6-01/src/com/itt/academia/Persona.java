package com.itt.academia;

/**
 * Clase abstracta que representa a una persona.<br>
 * De esta clase derivan las clases Profesor, Alumno y Administrativo.
 * @author Jana
 * @see Profesor
 * @version 2.0
 */
public abstract class Persona {
	private String nif;
	private String nombre;
	private String direccion;
	private String telefono;
	
	/**
	 * Constructor heredado por las clases derivadas de Persona
	 * @param nif NIF de la persona.
	 * @param nombre Nombre de la persona
	 * @param direccion Dirección de residencia de la persona
	 * @param telefono Teléfono de contacto de la persona
	 */
	protected Persona(String nif, String nombre, String direccion, String telefono) {
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	/**
	 * Método que envía a una persona a trabajar. Las clases derivadas de Persona deben especificar qué conlleva trabajar.
	 * @return Cadena que indica el tipo de tarea realizada.
	 */
	public abstract String trabajar();
	
	
	
	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion la direccion de la persona
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono el telefono the la persona
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * Método por el que un objeto de una clase derivada de Persona llama a otro.
	 * @param p Persona a la que se ha de llamar
	 * @return Cadena con los nombres de las personas involucradas en la llamada.
	 */
	public String llamar(Persona p) {
		return this.nombre + " llamando a " + p.nombre;
	}

	
	/**
	 * Método que devuelve una cadena con el Nombre, NIF, Dirección y Teléfono de la persona en el siguiente formato: 
	 * <p>
	 * Nombre: nombre<br>
	 * NIF: xxxxxxxxxz<br>
	 * Direccion: dirección de residencia<br>
	 * Teléfono: teléfono de contacto<br>
	 */
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\nNIF: " + this.nif + "\nDirección: " 
				+ this.direccion + "\nTeléfono: " + this.telefono; 
	}
}
