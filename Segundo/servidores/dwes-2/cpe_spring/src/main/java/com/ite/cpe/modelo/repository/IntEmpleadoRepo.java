package com.ite.cpe.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.cpe.modelo.beans.Empleado;

public interface IntEmpleadoRepo extends JpaRepository<Empleado, Integer> {
	@Query("select e from Empleado e where e.perfil.idPerfil = ?1")
	public List<Empleado> findByPerfil(int idPerfil);
}
