package com.ite.eventos.modelo.repository;

import java.util.List;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.bean.Reserva;
import com.ite.eventos.modelo.bean.Cliente;

/**
 * Interfaz que contiene los metodos del repositorio simulado de Reservas
 * @author hannah
 *
 */
public interface IntReservaRepo {
	int reservar(Evento evento, Cliente cliente, int cantidad);
	List<Reserva> fetchAll();
	List<Reserva> findByCliente(int idCliente);
	List<Reserva> findByEvento(Evento evento);
}
