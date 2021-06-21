package itt.com.teatro;
/**
 * La clase Obra representa obras de teatro
 * @author hannnah
 * @version 1.0
 * @since 1.0
 */
public class Obra {
	private String titulo;
	private String genero;
	private int minutosDuracion;
	
	/**
	 * Constructor de la clase Obra
	 * @param titulo
	 * @param genero
	 * @param minutosDuracion
	 */
	public Obra(String titulo, String genero, int minutosDuracion) {
		this.titulo = titulo;
		this.genero = genero;
		this.minutosDuracion = minutosDuracion;
	}
	
	/**
	 * @return el título de la obra
	 */
	public String getTitulo() {
		return this.titulo;
	}
	/**
	 * @param titulo el título de la obra
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return el género de la obra
	 */
	public String getGenero() {
		return this.genero;
	}
	/**
	 * @param genero el género de la obra
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * @return la duración de la obra en minutos
	 */
	public int getMinutosDuracion() {
		return this.minutosDuracion;
	}
	/**
	 * @param minutos
	 */
	public void setMinutosDuracion(int minutos) {
		this.minutosDuracion = minutos;
	}
	
	@Override
	public String toString() {
		return "Obra:\nTítulo: " + this.titulo + "\nGénero: " + this.genero + "\nDuración: " + this.minutosDuracion + " minutos.";
	}
}
