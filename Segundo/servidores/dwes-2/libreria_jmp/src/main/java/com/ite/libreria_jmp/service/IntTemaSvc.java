package com.ite.libreria_jmp.service;

import java.util.List;

import com.ite.libreria_jmp.model.beans.Tema;

public interface IntTemaSvc {
	void inicializarTemas();
	List<Tema> fetchAll();
	Tema findById(int idTema);
	Tema findByAbreviatura(String abreviatura);
	Tema findByDescripcion(String descripcion);
	int insertOne(Tema tema);
}
