package com.ite.eventos.modelo.repository;

import java.util.List;

import com.ite.eventos.modelo.bean.Evento;


/**
 * Interfaz que define las acciones relacionadas con eventos
 * @author hannah
 *
 */
public interface IntEventoRepo {
	
	List<Evento> fetchAll();
	List<Evento> findByEstado(String estado);
	List<Evento> fetchDestacados();
	
	Evento findById(int idEvento);
	int registrarEvento(Evento evento);
	int editarEvento(Evento idEvento);
	int eliminarEvento(int idEvento);
	int cancelarEvento(int idEvento);
	int activarEvento(int idEvento);
}
