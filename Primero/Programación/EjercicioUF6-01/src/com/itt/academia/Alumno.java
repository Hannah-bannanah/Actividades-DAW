package com.itt.academia;
/**
 * Clase que representa a un Alumno. Esta clase deriva de la clase {@link Persona}
 * @author Jana
 * @see Persona
 * @since v3.0
 * @version 1.0
 */
public class Alumno extends Persona{
	
	private static final int HORAS_NECESARIAS = 4;
	
	private String curso;
	private int horasEstudio;
	
	/**
	 * Constructor completo de la clase Alumno
	 * @param nif NIF del alumno.
	 * @param nombre Nombre del alumno
	 * @param direccion Dirección de residencia del alumno
	 * @param telefono Teléfono de contacto del alumno
	 * @param curso Curso en que está matriculado el alumno
	 */
	public Alumno(String nif, String nombre, String direccion, String telefono, String curso) {
		super(nif, nombre, direccion, telefono);
		this.curso = curso;
		this.horasEstudio = 0;
	}
	
	/**
	 * @return el curso en que está matriculado el alumno
	 */
	public String getCurso() {
		return curso;
	}


	/**
	 * @param curso el curso en el que se ha de matricular al alumno
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}


	/**
	 * @return las horasEstudio realizadas por el alumno
	 */
	public int getHorasEstudio() {
		return horasEstudio;
	}
	
	/**
	 * Método que indica si un alumno ha estudiado lo suficiente para asegurar el aprobado del examen
	 * @return true si el alumno ha estudiado suficiente, false si no.
	 */
	public boolean necesitaEstudiar() {
		return this.horasEstudio < Alumno.HORAS_NECESARIAS;
	}

	/**
	 * Método que envía al alumno a estudiar y suma 1 a las horas totales de estudio.
	 * @return una cadena informando que el alumno ha estudiado y cuantas hora de estudio lleva.
	 */
	@Override
	public String trabajar() {
		this.horasEstudio ++;
		return "El alumno " + super.getNombre() + " ha estudiado 1h para el curso " + this.curso 
				+ ". Lleva un total de " + this.horasEstudio + " horas de estudio en este curso.";
	}
	
	/**
	 * Método que envía al alumno a hacer un examen, dándole ánimos si ha estudiado lo suficiente.<br>
	 * @return cadena informando que el alumno va a hacer el examen.
	 */
	public String hacerExamen() {
		if (this.horasEstudio >= Alumno.HORAS_NECESARIAS) {
			return "Tras mucho estudiar, el alumno " + super.getNombre() + " va a petarlo en el examen!";
		} else {
			return "El alumno " + super.getNombre() + " va a hacer el examen, a pesar de no haber estudiado lo suficiente";
		}
	}
	
	/**
	 * Método que devuelve una cadena con el Nombre, NIF, Dirección, Teléfono, Curso y horas estudiadas del alumno en el siguiente formato: 
	 * <p>
	 * Alumno: <br>
	 * Nombre: nombre<br>
	 * NIF: xxxxxxxxxz<br>
	 * Direccion: dirección de residencia<br>
	 * Teléfono: teléfono de contacto<br>
	 * Curso: programación <br>
	 * Horas estudiadas: 0h
	 */
	@Override
	public String toString() {
		return "Alumno:\n" + super.toString() + "\nCurso: " + this.curso + "\nHoras estudiadas: " + this.horasEstudio + "h"; 
	}	
}