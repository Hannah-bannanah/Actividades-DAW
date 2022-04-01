package com.ite.eventos.modelo.repository;

import java.util.List;

import com.ite.eventos.modelo.bean.Tipo;


/**
 * Interfaz que define las acciones relacionadas con 
 * tipos de evento. Para la A1, solo proporciona una lista de 
 * los tipos disponibles
 * 
 * @author hannah
 *
 */
public interface IntTipoRepo {
	List<Tipo> fetchAll();
	Tipo findById(int idTipo);
}
