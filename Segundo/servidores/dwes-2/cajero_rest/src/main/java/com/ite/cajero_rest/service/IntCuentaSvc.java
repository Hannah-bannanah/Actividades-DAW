package com.ite.cajero_rest.service;

import java.util.List;

import com.ite.cajero_rest.model.beans.Cuenta;
import com.ite.cajero_rest.model.beans.Movimiento;

public interface IntCuentaSvc {
	List<Cuenta> fetchAll();
	Cuenta findById(int idCuenta);
	Cuenta validarCuenta(int idCuenta);
	int extraer(Movimiento movimiento);
	int ingresar(Movimiento movimiento);
	int realizarTransferencia(Cuenta origen, Cuenta destino, int cantidad);
	List<Movimiento> fecthMovimientos(int idCuenta);
}
