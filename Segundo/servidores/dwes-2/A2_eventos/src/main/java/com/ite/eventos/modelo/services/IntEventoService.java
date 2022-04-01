package com.ite.eventos.modelo.services;

import java.util.List;

import com.ite.eventos.modelo.bean.Evento;

public interface IntEventoService {
	List<Evento> fetchAll();
	List<Evento> findByEstado(String estado);
	List<Evento> fetchDestacados();
	
	Evento findById(int idEvento);
	int registrarEvento(Evento evento);
	int editarEvento(Evento eventoActualizado, int idEvento);
	int eliminarEvento(int idEvento);
	int cancelarEvento(int idEvento);
	int activarEvento(int idEvento);
}
