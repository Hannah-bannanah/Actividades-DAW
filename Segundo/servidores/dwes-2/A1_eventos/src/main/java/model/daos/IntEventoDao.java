package model.daos;

import java.util.List;

import model.beans.Evento;

/**
 * Interfaz que define las acciones relacionadas con eventos
 * @author hannah
 *
 */
public interface IntEventoDao {
	
	List<Evento> fetchAll();
	List<Evento> findByEstado(String estado);
	List<Evento> fetchDestacados();
	
	Evento findById(int idEvento);
	int registrarEvento(Evento evento);
	int editarEvento(Evento idEvento);
	int eliminarEvento(int idEvento);
	int cancelarEvento(int idEvento);
}
