package com.itt.libreria;

public class Libro {
	
	private String titulo;
	private String genero;
	private Autor autor;
	
	/**
	 * Constructor de la clase Libro
	 * @param titulo Título del libro
	 * @param genero Género del libro (e.g. "historia", "misterio")
	 * @param autor Autor del libro
	 */
	public Libro(String titulo, String genero, Autor autor) {
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
	}

	
	/**
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo el titulo del libro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}


	/**
	 * @param genero el genero del libro
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}


	/**
	 * @return autor
	 */
	public Autor getAutor() {
		return autor;
	}


	/**
	 * @param autor el autor del libro
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	/**
	 * Método que devuelve una cadena con el tíltulo, autor y género del libro
	 */
	@Override
	public String toString() {
		return "Libro de género " + this.genero + " titulado " + this.titulo + " escrito por " + this.autor;
	}
}
