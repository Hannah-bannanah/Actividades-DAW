package com.ite.cpe.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.cpe.modelo.beans.Proyecto;

public interface IntProyectoRepo extends JpaRepository<Proyecto, String>{

	@Query("select p from Proyecto p where p.jefeProyecto.idEmpl = ?1")
	public List<Proyecto> findByJefe(int idEmpl);
}
