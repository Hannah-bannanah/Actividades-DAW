package com.itt.academia;
import java.util.Queue;
import java.util.PriorityQueue;
/**
 * Clase que representa a un administrativo. Esta clase deriva de la clase {@link Persona}
 * @author Jana
 * @see Persona
 * @since v4.0
 * @version 1.0
 */
public class Administrativo extends Persona {
	private Queue <String> tareas = new PriorityQueue <String>();

	/**
	 * Constructor completo de la clase Administrativo
	 * @param nif NIF del administrativo.
	 * @param nombre Nombre del administrativo
	 * @param direccion Dirección de residencia del administrativo
	 * @param telefono Teléfono de contacto del administrativo
	 * @param tareas Tareas del administrativo
	 */
	public Administrativo(String nif, String nombre, String direccion, String telefono, String[] tareas) {
		super(nif, nombre, direccion, telefono);
		for (String tarea: tareas) {
			this.tareas.add(tarea);
		}
	}

	/**
	 * @return tareas
	 */
	public Queue<String> getTareas() {
		return tareas;
	}

	/**
	 * @param tareas las tareas del administrativo
	 */
	public void setTareas(Queue<String> tareas) {
		this.tareas = tareas;
	}

	/**
	 * Metodo que añade una tarea a lista
	 * @param tarea tarea a añadir
	 */
	public void anadirTareas(String tarea) {
		this.tareas.add(tarea);
	}

	/**
	 * Método que añade una serie de tareas a lista 
	 * @param tareas array de tareas a añadir
	 */
	public void anadirTareas(String[] tareas) {
		for (String tarea: tareas) {
			this.tareas.add(tarea);
		}
	}
	/**
	 * Método que envía al administrativo a realizar sus tareas.
	 * @return una cadena informando que el administrativo está realizando sus tareas.
	 */
	@Override
	public String trabajar() {
		if (this.tareas.isEmpty()) {
			return "El administrativo no tiene más tareas en su lista";
		} else {
			return "El administrativo " + super.getNombre() + " esta realizando la siguientes tarea: "
					+ this.tareas.remove();
		}
		
	}
	
	/**
	 * Método que envía al administrativo a gestionar una matrícula
	 * @return cadena informando que el administrativo está gestionando una matrícula
	 */
	public String gestionarMatricula() {
		return "El administrativo " + super.getNombre() + " está gestionando una matrícula.";
	}
	
	/**
	 * Método que devuelve una cadena con el Nombre, NIF, Dirección, Teléfono y Tareas del administrativo en el siguiente formato: 
	 * <p>
	 * Administrativo: <br>
	 * Nombre: nombre<br>
	 * NIF: xxxxxxxxxz<br>
	 * Direccion: dirección de residencia<br>
	 * Teléfono: teléfono de contacto<br>
	 * Tareas: administrar
	 */
	@Override
	public String toString() {
		return "Administrativo:\n" + super.toString()+ "\nTareas: " + this.tareas; 
	}
}
