package com.ite.libreria_jmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.libreria_jmp.model.beans.Perfil;

public interface PerfilRepo extends JpaRepository<Perfil, Integer> {
	@Query("select perf from Perfil perf where perf.descripcion = ?1")
	public Perfil buscarPorDescripcion(String descripcion);
}
