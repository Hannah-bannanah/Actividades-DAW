package com.ite.eventos.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.bean.Reserva;
import com.ite.eventos.modelo.bean.Cliente;
import com.ite.eventos.modelo.repository.IntReservaRepo;

@Service
public class ReservaServiceImpl implements IntReservaService {
	@Autowired
	IntReservaRepo iReservas;
	
	@Autowired
	IntClienteService usuarioService;
	
	@Autowired
	IntEventoService eventoService;

	@Override
	public int reservar(int idEvento, int idCliente, int cantidad) {
		
		//obtenemos cliente y evento
		Cliente cliente = usuarioService.findById(idCliente);
		Evento evento = eventoService.findById(idEvento);
		
		//comprobamos que hay plazas disponibles
		if (this.plazasReservadas(evento.getIdEvento()) + cantidad > evento.getMaxAforo())
			return 0;
		
		//comprobamos que el usuario no tiene más de 10 plazas reservadas
		List<Reserva> reservasCliente = findByCliente(idCliente);
		int plazasReservadasCliente = 0;
		for (Reserva reserva : reservasCliente) {
			if (reserva.getEvento().equals(evento)) plazasReservadasCliente += reserva.getCantidad();
		}
		//comprobamos que el total no supera 10
		if (cantidad + plazasReservadasCliente > 10) return 0;		
				
		return iReservas.reservar(evento, cliente, cantidad);
	}

	@Override
	public List<Reserva> fetchAll() {
		return iReservas.fetchAll();
	}

	@Override
	public List<Reserva> findByCliente(int idCliente) {
		return iReservas.findByCliente(idCliente);
	}

	@Override
	public List<Reserva> findByEvento(Evento evento) {
		return iReservas.findByEvento(evento);
	}
	
	@Override
	public int plazasReservadas(int idEvento) {
		int plazasReservadas = 0;
		for (Reserva reserva : iReservas.fetchAll()) {
			if (reserva.getEvento().getIdEvento() == idEvento)
				plazasReservadas += reserva.getCantidad();
		}
		return plazasReservadas;
	}
}
