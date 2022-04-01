package com.ite.jana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.jana.model.beans.Evento;

public interface EventosRepo extends JpaRepository<Evento, Integer>{
	@Query("select e from Evento e where e.estado = ?1")
	public List<Evento> findByEstado(String estado);
	
	@Query("select e from Evento e where e.destacado = ?1")
	public List<Evento> findDestacados(String destacado);
	
	@Query("select e from Evento e where e.nombre like ?1")
	public List<Evento> buscarSubcadena(String subcadena);
}
