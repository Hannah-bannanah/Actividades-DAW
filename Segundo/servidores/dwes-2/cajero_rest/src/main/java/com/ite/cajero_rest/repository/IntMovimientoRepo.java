package com.ite.cajero_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.cajero_rest.model.beans.Movimiento;

public interface IntMovimientoRepo extends JpaRepository<Movimiento, Integer>{
	@Query("select m from Movimiento m where m.cuenta.idCuenta = ?1 order by m.fecha desc")
	public List<Movimiento> findByIdCuenta(int idCuenta);
}
