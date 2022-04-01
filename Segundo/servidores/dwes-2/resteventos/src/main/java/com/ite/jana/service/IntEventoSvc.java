package com.ite.jana.service;

import java.util.List;

import com.ite.jana.model.beans.Evento;

public interface IntEventoSvc {
	void inicializar();
	Evento findById(int idEvento);
	List<Evento> findActivos();
	List<Evento> findDestacados();
	List<Evento> buscarSubcadena(String subcadena);
	int getPlazasDisponibles(int idEvento);
	int crearEvento(Evento evento);
	int modificarEvento(Evento evento);
	int eliminarEvento(int idEvento);
}
