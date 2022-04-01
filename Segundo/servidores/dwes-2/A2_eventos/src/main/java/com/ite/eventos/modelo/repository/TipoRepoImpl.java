/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.bean.Tipo;

/**
 * Clase que implementa los métodos del servicio Tipo.
 * 
 * En la A1 se utiliza para generar una lista de tipos, que 
 * serán utilizados por el servico Eventos
 * @author hannah
 *
 */
@Repository
public class TipoRepoImpl implements IntTipoRepo {
	private List<Tipo> tipos;
	
	/**
	 * Constructor
	 */
	public TipoRepoImpl() {
		tipos = new ArrayList<Tipo>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		// crear tipos
		String[] nombres = {"Boda", "Cumpleanios", "Conferencia", "Graduacion"};
		for (int i = 0; i < 4; i++) {
			tipos.add(new Tipo(i+1, nombres[i], "Tipo: " +nombres[i]));
		}
	}

	@Override
	public List<Tipo> fetchAll() {
		return tipos;
	}

	@Override
	public Tipo findById(int idTipo) {
		for (Tipo tipo : tipos) {
			if (tipo.getIdTipo() == idTipo) return tipo;
		}
		return null;
	}
	
}
