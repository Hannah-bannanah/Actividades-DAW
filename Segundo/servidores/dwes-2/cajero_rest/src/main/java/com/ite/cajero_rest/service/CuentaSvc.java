package com.ite.cajero_rest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.cajero_rest.model.beans.Cuenta;
import com.ite.cajero_rest.model.beans.Movimiento;
import com.ite.cajero_rest.repository.IntCuentaRepo;
import com.ite.cajero_rest.repository.IntMovimientoRepo;

@Service
public class CuentaSvc implements IntCuentaSvc{

	@Autowired
	private IntCuentaRepo crepo;
	
	@Autowired
	private IntMovimientoRepo mrepo;
	
	@Override
	public List<Cuenta> fetchAll() {
		return crepo.findAll();
	}
	
	@Override
	public Cuenta findById(int idCuenta) {
		return crepo.findById(idCuenta).orElse(null);
	}

	@Override
	public Cuenta validarCuenta(int idCuenta) {
		return findById(idCuenta);
	}

	@Override
	public int extraer(Movimiento movimiento) {
		int filas = 0;
		Cuenta cuenta = movimiento.getCuenta();
		if (cuenta.getSaldo() < movimiento.getCantidad()) return -1;
		try {
			mrepo.save(movimiento);
			cuenta.setSaldo(cuenta.getSaldo() - movimiento.getCantidad());
			crepo.save(cuenta);	
			filas = 2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}

	@Override
	public int ingresar(Movimiento movimiento) {
		int filas = 0;
		Cuenta cuenta = movimiento.getCuenta();
		try {
			mrepo.save(movimiento);
			cuenta.setSaldo(cuenta.getSaldo() + movimiento.getCantidad());
			crepo.save(cuenta);
			filas = 2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int realizarTransferencia(Cuenta origen, Cuenta destino, int cantidad) {
		int filas = 0; 
		Movimiento cargo = new Movimiento();
		cargo.setCantidad(cantidad);
		cargo.setCuenta(origen);
		cargo.setOperacion("cargo por transferencia");
		cargo.setFecha(new Date());
		
		int resultadoCargo = extraer(cargo);
		if (resultadoCargo != 2) return resultadoCargo;
		filas += resultadoCargo;
		
		Movimiento abono = new Movimiento();
		abono.setCantidad(cantidad);
		abono.setCuenta(destino);
		abono.setOperacion("abono por transferencia");
		abono.setFecha(new Date());
		
		int resultadoAbono = ingresar(abono);
		if (resultadoAbono != 2) {
			Movimiento deshacerCargo = new Movimiento();
			deshacerCargo.setCantidad(cantidad);
			deshacerCargo.setCuenta(origen);
			deshacerCargo.setOperacion("devolucion");
			deshacerCargo.setFecha(new Date());
			ingresar(deshacerCargo);
			return resultadoAbono;
		};
		filas += resultadoAbono;
		
		return filas;
	}

	@Override
	public List<Movimiento> fecthMovimientos(int idCuenta) {
		return mrepo.findByIdCuenta(idCuenta);
	}



}
