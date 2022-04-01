package com.ite.libreria_jmp.service;

import java.util.List;

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.Tema;

public interface IntLibroSvc {
	void inicializarLibros();
	List<Libro> fetchAll();
	Libro findByIsbn(long isbn);
	int insertOne(Libro libro);
	int updateOne(Libro libro);
	int eliminar(long isbn);
	List<Libro> fetchNovedades();
	List<Libro> fetchByTema(Tema tema);
	List<Libro> searchByTitle(String subcadena);
}
