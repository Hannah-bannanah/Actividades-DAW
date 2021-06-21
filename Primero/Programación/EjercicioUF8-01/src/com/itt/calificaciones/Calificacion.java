package com.itt.calificaciones;

public class Calificacion {
	private String asignatura;
	private int nota; //Valor de 0 a 100

	//Constructor que reciba argumentos para las dos propiedades
	/**
	 * Constructor de la clase Calificacion
	 * @param asignatura
	 * @param nota
	 */
	protected Calificacion(String asignatura, int nota) {
		super();
		this.asignatura = asignatura;
		this.nota = nota > 100?100:nota<0?0:nota;
	}

	//Métodos get/set
	/**
	 * @return la asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura la asignatura a actualizar
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return la nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * @param nota la nota a actualizar
	 */
	public void setNota(int nota) {
		if (nota >= 0 && nota <= 100) {
			this.nota = nota;
		} else {
			System.out.println("La nota debe estar entre 0 y 100, ambos inclusive");
		}
	}
	
	@Override
	/**
	 * @return una cadena con la asignatura y nota de la calificación
	 */
	public String toString() {
		return this.asignatura + ": " + this.nota;
	}
}
