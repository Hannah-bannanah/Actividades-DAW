/**
 * 
 */
package com.ite.cajero.modelo.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.cajero.modelo.beans.Movimiento;

/**
 * @author hannah
 *
 */
public interface IntMovimientoRepo extends JpaRepository<Movimiento, Integer>{
//	@Query("select m from Movimiento m where m.cuenta.idCuenta = ?1 order by m.fecha desc")
//	public List<Movimiento> findByIdCuenta(int idCuenta);
	
//	@Query(
//			value = "SELECT * FROM MOVIMIENTOS m WHERE id_cuenta = ?1 ORDER BY fecha LIMIT ?2", 
//			nativeQuery = true)
//	public List<Movimiento> mostrarUltimos(int idCuenta, int numero);
	
	@Query("select m FROM Movimiento m where m.cuenta.idCuenta = ?1 order by m.fecha desc")
    public Page<Movimiento> mostrarUltimosPaginados(int idCuenta, Pageable pageable);
}
