package com.ite.eventos.modelo.services;

import java.util.List;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.bean.Reserva;

public interface IntReservaService {
	int reservar(int idEvento, int idCliente, int cantidad);
	List<Reserva> fetchAll();
	List<Reserva> findByCliente(int idCliente);
	List<Reserva> findByEvento(Evento evento);
	
	int plazasReservadas(int idEvento);
}
