package com.itt.libreria;

public class Autor {
	
	private String nombre;
	private String biografia;
	
	/**
	 * Constructor de la clase autor
	 * @param nombre Nombre del autor
	 * @param biografia Biografía del autor
	 */
	public Autor(String nombre, String biografia) {
		this.nombre = nombre;
		this.biografia = biografia;
	}	

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre del autor
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return biografia
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * @param biografia la biografia del autor
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	/**
	 * Método que devuelve una cadena informando del nombre y biografía del objeto Autor
	 */
	@Override
	public String toString() {
		return "Autor " + this.nombre + "\nBiografía: " + this.biografia;
	}
}
