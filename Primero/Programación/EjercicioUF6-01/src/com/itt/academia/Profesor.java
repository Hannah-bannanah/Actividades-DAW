package com.itt.academia;
/**
 * Clase que representa a un Pofesor. Esta clase deriva de la clase {@link Persona}
 * @author hannnah
 * @see Persona
 * @since v2.0
 * @version 1.0
 */
/**
 * @author Jana
 *
 */
public class Profesor extends Persona{
	
	private String competencias;

	/**
	 * Constructor básico de la clase Profesor, para un profesor sin competencias ni talento
	 * @param nif NIF del profesor.
	 * @param nombre Nombre del profesor
	 * @param direccion Dirección de residencia del profesor
	 * @param telefono Teléfono de contacto del profesor
	 */
	public Profesor(String nif, String nombre, String direccion, String telefono) {
		super(nif, nombre, direccion, telefono);
		this.competencias = "";
	}
	
	/**
	 * Constructor completo de la clase Profesor, para un profesor con competencias.
	 * @param nif NIF del profesor.
	 * @param nombre Nombre del profesor
	 * @param direccion Dirección de residencia del profesor
	 * @param telefono Teléfono de contacto del profesor
	 * @param competencias Competencias del profesor
	 */
	public Profesor(String nif, String nombre, String direccion, String telefono, String competencias) {
		super(nif, nombre, direccion, telefono);
		this.competencias = competencias;
	}

	/**
	 * @return competencias
	 */
	public String getCompetencias() {
		return competencias;
	}

	/**
	 * @param competencias las competencias del profesor
	 */
	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	/**
	 * Método que envía a un profesor a impartir su clase.<br>
	 * @return una cadena informando que el profesor ha ido a impartir su clase. Si el profesor tiene 
	 * competencias asignadas, se especificará en la cadena devuelta.
	 */
	@Override
	public String trabajar() {
		String cadena = "El profesor " + super.getNombre() + " va a impartir su clase";
		cadena = this.competencias.length()>0?cadena+" de "+this.competencias+".":cadena+".";
		return cadena;
	}
	
	/**
	 * Método que envía a un profesor a corregir exámenes.
	 * @return una cadena informando que el profesor ha ido a corregir los exámenes. Si el profesor tiene
	 * competencias asignadas, se especificará en la cadena devuelta.
	 */
	public String ponerNotas() {
		String cadena = "El profesor " + super.getNombre() + " va a corregir los exámenes";
		cadena = this.competencias.length()>0?cadena+" de "+this.competencias+".":cadena+".";
		return cadena;
	}
	
	/**
	 * Método que devuelve una cadena con el Nombre, NIF, Dirección, Teléfono y Competencias del profesor en el siguiente formato: 
	 * <p>
	 * Profesor: <br>
	 * Nombre: nombre<br>
	 * NIF: xxxxxxxxxz<br>
	 * Direccion: dirección de residencia<br>
	 * Teléfono: teléfono de contacto<br>
	 * Competencias: profesorar
	 */
	@Override
	public String toString() {
		return "Profesor:\n" + super.toString() + "\nCompetencias: " + this.competencias; 
	}
}
