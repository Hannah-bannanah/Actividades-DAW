package model.daos;

import java.util.List;

import model.beans.TipoEvento;

/**
 * Interfaz que define las acciones relacionadas con 
 * tipos de evento. Para la A1, solo proporciona una lista de 
 * los tipos disponibles
 * 
 * @author hannah
 *
 */
public interface IntTipoEventoDao {
	List<TipoEvento> fetchAll();
	TipoEvento findById(int idTipo);
}
