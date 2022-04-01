package com.ite.libreria_jmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.libreria_jmp.model.beans.Tema;

public interface TemaRepo extends JpaRepository<Tema, Integer>{
	@Query("select t from Tema t where t.abreviatura = ?1")
	public Tema findByAbreviatura(String abreviatura);
	
	@Query("select t from Tema t where t.descTema = ?1")
	public Tema findByDescripcion(String descripcion);
}
