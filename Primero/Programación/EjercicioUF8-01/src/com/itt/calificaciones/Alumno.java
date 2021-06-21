package com.itt.calificaciones;
import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private int matricula;
	private ArrayList<Calificacion> calificaciones;
	public ArrayList<String> numeros = new ArrayList<String>();

	
	/**
	 * Constructor de la clase Alumno
	 * @param nombre el nombre del alumno
	 * @param matricula la matrícula del alumno
	 */
	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.calificaciones = new ArrayList<Calificacion>();
		
		
	}

	//añadir los métodos get para las tres propiedades
	/**
	 * @return el nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return la matrícula del alumno
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
	 * @return las calificaciones del alumno
	 */
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	/**
	 * Añade una calificación a la lista de calificaciones del alumno
	 * @param asignatura
	 * @param nota
	 */
	public void calificar(String asignatura, int nota) {	
		this.calificaciones.add(new Calificacion(asignatura, nota));
	}
	
	//método que calcula la nota media del alumno
	/**
	 * @return nota media del alumno redondeada al entero más próximo
	 */
	public int calcularMedia() {
		int media = 0;
		for (Calificacion calificacion: this.calificaciones) {
			media += calificacion.getNota();
		}
		media = Math.round(media / this.calificaciones.size());
		return media;
	}
	
	/**
	 * @return cadena que lista todas las calificaciones del alumno
	 */
	public String listarCalificaciones() {
		String cadena = "Listado de calificaciones:";
		for (Calificacion calificacion : this.calificaciones) {
			cadena = cadena + "\n" + calificacion.toString();
		}	
		return cadena;
	}
	
	@Override
	/**
	 * @return una cadena con la información sobre el alumno
	 */
	public String toString() {
		return "Alumno matricula: " + this.matricula + " - " + this.nombre;
	}
}
