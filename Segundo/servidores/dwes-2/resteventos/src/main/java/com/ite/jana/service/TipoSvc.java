package com.ite.jana.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.jana.model.beans.Tipo;
import com.ite.jana.repository.TiposRepo;

@Service
public class TipoSvc implements IntTipoSvc{
	
	@Autowired
	private TiposRepo trepo;

	/**
	 * Obtiene todos los tipos
	 * @return la lista de tipos
	 */
	@Override
	public List<Tipo> fetchAll() {
		return trepo.findAll();
	}

	/**
	 * Obtiene un tipo al azar
	 * @return un tipo aleatorio
	 */
	@Override
	public Tipo findRandom() {
		List<Tipo> tipos = fetchAll();
		Random rd = new Random();
		int idx = rd.nextInt(tipos.size());
		return tipos.get(idx);
	}

	/**
	 * Busca un tipo por id
	 * @param idTipo el id del tipo a buscar
	 * @return el tipo si existe, null si no
	 */
	@Override
	public Tipo findById(int idTipo) {
		return trepo.findById(idTipo).orElse(null);
	}

}
