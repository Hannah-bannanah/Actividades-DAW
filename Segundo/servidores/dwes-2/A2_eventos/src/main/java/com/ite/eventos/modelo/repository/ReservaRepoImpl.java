/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.bean.Reserva;
import com.ite.eventos.modelo.bean.Cliente;

/**
 * 
 * Clase que implementa los metodos del repositorio de Reserva
 * @author hannah
 *
 */
@Repository
public class ReservaRepoImpl implements IntReservaRepo{
	
	private List<Reserva> reservas;
	
	/**
	 * Constructor
	 */
	public ReservaRepoImpl() {
		reservas = new ArrayList<Reserva>();
		cargarDatos();
	}

	private void cargarDatos() {
		for (int i = 0; i < 10; i++) {
			Evento evento = new Evento();
			evento.setIdEvento(1500 + i);
			evento.setNombre("ejemplo evento");
			Cliente cliente = new Cliente();
			cliente.setIdCliente(1501 + i);
			double precio = 10.25 + i;
			String observaciones = "Mi reserva numero " + i;
			int cantidad = 1 + i;
			
			Reserva reserva = new Reserva(evento, cliente, precio, observaciones, cantidad);
			reservas.add(reserva);
		}
				
	}

	@Override
	public int reservar(Evento evento, Cliente cliente, int cantidad) {	
		Reserva nuevaReserva = new Reserva(evento, cliente, evento.getPrecio(), "reserva", cantidad);
		return reservas.add(nuevaReserva) ? 1 : 0;
	}

	@Override
	public List<Reserva> fetchAll() {
		return reservas;
	}

	@Override
	public List<Reserva> findByCliente(int idCliente) {
		List<Reserva> reservasUsuario = new ArrayList<Reserva>();
		for (Reserva reserva: reservas) {
			if (reserva.getCliente().getIdCliente() == idCliente) {
				reservasUsuario.add(reserva);
			}
		}
		return reservasUsuario;
	}
	
	@Override
	public List<Reserva> findByEvento(Evento evento){
		List<Reserva> reservasEvento = new ArrayList<Reserva>();
		for (Reserva reserva : reservas) {
			if (reserva.getEvento().equals(evento));
				reservasEvento.add(reserva);
		}
		return reservasEvento;
	}

//	@Override
//	public int plazasReservadas(int idEvento) {
//		int plazasReservadas = 0;
//		for (Reserva reserva : reservas) {
//			if (reserva.getEvento().getIdEvento() == idEvento)
//				plazasReservadas += reserva.getCantidad();
//		}
//		return plazasReservadas;
//	}

}
