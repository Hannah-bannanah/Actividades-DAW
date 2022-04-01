package com.ite.eventos.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.repository.IntEventoRepo;

@Service
public class EventoServiceImpl implements IntEventoService{

	@Autowired
	private IntEventoRepo iEventos;
	
	@Override
	public List<Evento> fetchAll() {
		return iEventos.fetchAll();
	}

	@Override
	public List<Evento> findByEstado(String estado) {
		return iEventos.findByEstado(estado);
	}

	@Override
	public List<Evento> fetchDestacados() {
		return iEventos.fetchDestacados();
	}

	@Override
	public Evento findById(int idEvento) {
		return iEventos.findById(idEvento);
	}

	@Override
	public int registrarEvento(Evento evento) {
		return iEventos.registrarEvento(evento);
	}

	@Override
	public int editarEvento(Evento eventoActualizado, int idEvento) {
		eventoActualizado.setIdEvento(idEvento);
		return iEventos.editarEvento(eventoActualizado);
	}

	@Override
	public int eliminarEvento(int idEvento) {
		return iEventos.eliminarEvento(idEvento);
	}

	@Override
	public int cancelarEvento(int idEvento) {
		return iEventos.cancelarEvento(idEvento);
	}

	@Override
	public int activarEvento(int idEvento) {
		return iEventos.activarEvento(idEvento);
	}

}
