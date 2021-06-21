package itt.com.teatro;

/**
 * La interfaz Sala contiene métodos relativos a un espectáculo
 * @author hannnah
 * @version 1.0
 */

public interface Sala {
	
	/**
	 * @return un listado con el programa de la sala
	 */
	String verProgramacion();
	
	/**
	 * @return un listado de todas las localidades en la sala
	 */
	String verLocalidades();
	
	/**
	 * @return un listado de todas las localidades ocupadas de la sala
	 */
	String verLocalidadesOcupadas();
	
	/**
	 * Realiza las gestiones necesarias para asignar una localidad a un espectador. 
	 * Es necesario marcar la localidad como ocupada como parte de este proceso.
	 * @param fila
	 * @param butaca
	 * @param espectador
	 * @return confirmación de la venta si la operación se ha completado con éxito, mensaje de error si no
	 */
	String venderLocalidad(int fila, int butaca, Espectador espectador);
	
	/**
	 * Realiza las gestiones necesarias para liberar una butaca vendida
	 * @param fila
	 * @param butaca
	 * @return confirmación de la cancelación si la operación se ha completado con éxito, mensaje de error si no
	 */
	String cancelarLocalidad(int fila, int butaca);
	
	/**
	 * @param fila
	 * @param butaca
	 * @return una cadena con los detalles relevantes de la localidad
	 */
	String consultarLocalidad(int fila, int butaca);
	
	/**
	 * @return el total recaudado por la venta de localidades de la sala
	 */
	double calcularRecaudacion();
}
