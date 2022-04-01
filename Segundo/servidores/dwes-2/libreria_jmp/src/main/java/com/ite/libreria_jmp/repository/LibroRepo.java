package com.ite.libreria_jmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.libreria_jmp.model.beans.Libro;

public interface LibroRepo extends JpaRepository<Libro, Long>{
	@Query("select l from Libro l where l.novedad = 's'")
	public List<Libro> fetchNovedades();
	
	@Query("select l from Libro l where l.tema.idTema = ?1")
	public List<Libro> fetchByTema(int idTema);
	
	@Query("select l from Libro l where l.titulo like ?1")
	public List<Libro> searchTitles(String regex);
}
