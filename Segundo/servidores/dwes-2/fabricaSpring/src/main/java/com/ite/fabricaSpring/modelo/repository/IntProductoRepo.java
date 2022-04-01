package com.ite.fabricaSpring.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.fabricaSpring.modelo.beans.Producto;

public interface IntProductoRepo extends JpaRepository<Producto, Integer>{
	@Query("select p from Producto p where p.familia.idFamilia = ?1")
	public List<Producto> findByFamilia(int idFamilia);
}
