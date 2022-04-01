package com.ite.eventos.modelo.bean;

import java.io.Serializable;
import java.util.Objects;

public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int ultimoId = 0;
	
	private int idReserva;
	private Evento evento;
	private Cliente cliente;
	private double precioVenta;
	private String observaciones;
	private int cantidad;
	
	/**
	 * 
	 */
	public Reserva() {
		super();
		this.idReserva = ++Reserva.ultimoId;
	}

	/**
	 * @param idReserva
	 * @param evento
	 * @param cliente
	 * @param precioVenta
	 * @param observaciones
	 * @param cantidad
	 */
	public Reserva(Evento evento, Cliente cliente, double precioVenta, String observaciones,
			int cantidad) {
		super();
		this.idReserva = ++Reserva.ultimoId;
		this.evento = evento;
		this.cliente = cliente;
		this.precioVenta = precioVenta;
		this.observaciones = observaciones;
		this.cantidad = cantidad;
	}

	/**
	 * @return the idReserva
	 */
	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * @param idReserva the idReserva to set
	 */
//	public void setIdReserva(int idReserva) {
//		this.idReserva = idReserva;
//	}

	/**
	 * @return the evento
	 */
	public Evento getEvento() {
		return evento;
	}

	/**
	 * @param evento the evento to set
	 */
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return idReserva == other.idReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", evento=" + evento + ", cliente=" + cliente + ", precioVenta="
				+ precioVenta + ", observaciones=" + observaciones + ", cantidad=" + cantidad + "]";
	}
	
	
}
