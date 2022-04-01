/**
 * 
 */
package model.daos;

import java.util.ArrayList;
import java.util.List;

import model.beans.TipoEvento;


/**
 * Clase que implementa los métodos del servicio TipoEvento.
 * 
 * En la A1 se utiliza para generar una lista de tipos, que 
 * serán utilizados por el servico Eventos
 * @author hannah
 *
 */
public class TipoEventoDaoImpl implements IntTipoEventoDao {
	private List<TipoEvento> tipos;
	
	/**
	 * Constructor
	 */
	public TipoEventoDaoImpl() {
		tipos = new ArrayList<TipoEvento>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		// crear tipos
		String[] nombres = {"Boda", "Cumpleanios", "Conferencia", "Graduacion"};
		for (int i = 0; i < 4; i++) {
			tipos.add(new TipoEvento(i+1, nombres[i], "Tipo: " +nombres[i]));
		}
	}

	@Override
	public List<TipoEvento> fetchAll() {
		return tipos;
	}

	@Override
	public TipoEvento findById(int idTipo) {
		for (TipoEvento tipo : tipos) {
			if (tipo.getIdTipo() == idTipo) return tipo;
		}
		return null;
	}
	
}
