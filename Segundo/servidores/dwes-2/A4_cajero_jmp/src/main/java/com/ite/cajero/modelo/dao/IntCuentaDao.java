/**
 * 
 */
package com.ite.cajero.modelo.dao;

import java.util.List;

import com.ite.cajero.modelo.beans.Cuenta;
import com.ite.cajero.modelo.beans.Movimiento;

/**
 * @author hannah
 *
 */
public interface IntCuentaDao {
	Cuenta findById(int idCuenta);
	Cuenta validarCuenta(int idCuenta);
	int ingresarDinero(Movimiento movimiento);
	int extraerDinero(Movimiento movimiento);
	int transferencia(Cuenta origen, Cuenta destino, int cantidad);
	List<Movimiento> fetchMovimientos(int idCuenta);
}
