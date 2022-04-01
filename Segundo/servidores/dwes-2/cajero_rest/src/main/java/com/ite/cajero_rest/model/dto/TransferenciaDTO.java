package com.ite.cajero_rest.model.dto;

import org.springframework.stereotype.Component;

@Component
public class TransferenciaDTO {
	
	private int cantidad;
	private int idOrigen;
	private int idDestino;
	
	public TransferenciaDTO() {
		super();
	}
	
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the idOrigen
	 */
	public int getIdOrigen() {
		return idOrigen;
	}
	/**
	 * @param idOrigen the idOrigen to set
	 */
	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}
	/**
	 * @return the idDestino
	 */
	public int getIdDestino() {
		return idDestino;
	}
	/**
	 * @param idDestino the idDestino to set
	 */
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	
	
}
