package com.itt.maquinaexpendedora;

import java.util.List;
import java.util.ArrayList;
import exceptions.*;

public class Maquina {
	private List<Bebida> bebidas;
	private float recoleccion;
	private final String CONTRASENA_OPERARIO = "operario1";
	
	/**
	 * Constructor básico de una máquina de bebidas vacía
	 */
	public Maquina() {
		this.bebidas = new ArrayList<Bebida>();
	}
	
	/**
	 * Constructor de una máquina de bebidas llena
	 */
	public Maquina(List<Bebida> bebidas) {
		this.bebidas = new ArrayList<Bebida>(bebidas);
	}
	
	/**
	 * @return the bebidas
	 */
	public List<Bebida> getBebidas() {
		return bebidas;
	}

	/**
	 * @return the recoleccion
	 */
	public float getRecoleccion() {
		return recoleccion;
	}

	/**
	 * Método que repone una bebida en la máquina
	 * @param bebida Bebida a reponer
	 */
	public void reponer(Bebida bebida) {
		this.bebidas.add(bebida);
	}
	
	/**
	 * Metodo que repone varias bebidas a la vez
	 * @param bebidas Lista de bebidas a reponer
	 */
	public void reponer(List<Bebida> bebidas) {
		this.bebidas.addAll(bebidas);
	}
	
	/**
	 * Método que vende una bebida.<br> 
	 * Al llamar a este método, la bebida seleccionada se elimina del stock de la máquina y el precio se añade a la recolección total
	 * @param bebida
	 */
	public void expenderBebida(Bebida bebida) throws bebidaAgotadaException {
		if (this.bebidas.contains(bebida)) {
			this.bebidas.remove(bebida);
			this.recoleccion += bebida.getPrecio();
		} else {
			throw new bebidaAgotadaException(bebida);
		}

	}
	
	/**
	 * Método que permite a un operario recoger el dinero recolectado por la máquina
	 * @return los dineros
	 */
	public float recogerRecoleccion() {
		float totalRecolectado = this.recoleccion;
		this.recoleccion = 0;
		return totalRecolectado;
	}
	
	/**
	 * Método que valida la contraseña introducida con la de operario
	 * @param contrasena
	 * @return true si la contraseña es válida
	 * @throws UsuarioNoAutorizadoException
	 */
	public boolean validarOperario(String contrasena) {
		if (!contrasena.equals(this.CONTRASENA_OPERARIO)) {
			throw new UsuarioNoAutorizadoException();
		}
		return true;
	}
}
