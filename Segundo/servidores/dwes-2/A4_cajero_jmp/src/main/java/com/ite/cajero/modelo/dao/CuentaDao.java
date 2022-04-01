/**
 * 
 */
package com.ite.cajero.modelo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ite.cajero.modelo.beans.Cuenta;
import com.ite.cajero.modelo.beans.Movimiento;
import com.ite.cajero.modelo.repo.IntCuentaRepo;
import com.ite.cajero.modelo.repo.IntMovimientoRepo;

/**
 * Servicio de Cuenta
 * @author hannah
 *
 */
@Service
public class CuentaDao implements IntCuentaDao{
	
	@Autowired
	private IntCuentaRepo cRepo;
	
	@Autowired
	private IntMovimientoRepo mRepo;

	/**
	 * Busca un objeto Cuenta a través de su idCuenta
	 * @param idCuenta el id de la cuenta buscada
	 * @return el objeto Cuenta si existe, null si no
	 */
	@Override
	public Cuenta findById(int idCuenta) {
		return cRepo.findById(idCuenta).orElse(null);
	}
	
	/**
	 * Valida si una cuenta existe
	 * Nota: este metodo actualmente solo valida si la cuenta existe,
	 * más adelante se implementará validación de usuario (por 
	 * contraseña/pin...etc)
	 * @param idCuenta el id de la cuenta buscada
	 * @return el objeto Cuenta si la validacion tiene exito, null si no
	 */
	@Override
	public Cuenta validarCuenta(int idCuenta) {
		return findById(idCuenta);
	}

	/**
	 * Realiza un ingreso definido por un Movimiento
	 * @param movimiento el movimiento a realizar
	 * @return el número de filas actualizadas tras la operación (por
	 * defecto, 2) si ha tenido éxito, 0 si no
	 */
	@Override
	public int ingresarDinero(Movimiento movimiento) {
		Cuenta cuenta = movimiento.getCuenta();
		int filas = 0;
		try {
			mRepo.save(movimiento);
			cuenta.setSaldo(cuenta.getSaldo() + movimiento.getCantidad());
			cRepo.save(cuenta);
			filas = 2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}

	/**
	 * Realiza una extracción definida por un Movimiento
	 * @param movimiento el movimiento a realizar
	 * @return el número de filas actualizadas tras la operación (por
	 * defecto, 2) si ha tenido éxito, -1 si la operación no se pudo
	 * realizar por falta de saldo, 0 si no se realizó la operación
	 * por otro motivo
	 */
	@Override
	public int extraerDinero(Movimiento movimiento) {
		if (movimiento.getCantidad() > movimiento.getCuenta().getSaldo()) return -1;
		int filas =0;
		Cuenta cuenta = movimiento.getCuenta();
		
		try {
			mRepo.save(movimiento);
			cuenta.setSaldo(cuenta.getSaldo() - movimiento.getCantidad());
			cRepo.save(cuenta);
			filas = 2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}

	/**
	 * Realiza una transferencia de una cuenta a otra
	 * @param origen la cuenta que realiza la transferencia
	 * @param destino la cuenta receptora de la transferencia
	 * @param cantidad cantidad a transferir
	 * @return el número de filas actualizadas tras la operación (por
	 * defecto, 4) si ha tenido éxito, -2 si la cuenta de destino no 
	 * existe, -1 si el saldo en origen es insuficiente, 0 si no se 
	 * realizó la operación por otro motivo
	 */
	@Override
	public int transferencia(Cuenta origen, Cuenta destino, int cantidad) {
		if (destino == null) return -2;
		if (origen.getSaldo() < cantidad) return -1;
		if (origen.equals(destino)) return 0;
		int filas = 0;
		
		Movimiento extraccion = new Movimiento (origen, cantidad, "cargo por transferencia");
		extraccion.setFecha(new Date());
		Movimiento ingreso = new Movimiento (destino, cantidad, "abono por transferencia");
		ingreso.setFecha(new Date());
		
		int resultadoCargo = extraerDinero(extraccion);
		if (resultadoCargo != 2) return resultadoCargo;
		filas += resultadoCargo;
		
		int resultadoAbono = ingresarDinero(ingreso);
		if (resultadoAbono != 2) {
			Movimiento deshacerCargo = new Movimiento();
			deshacerCargo.setCantidad(cantidad);
			deshacerCargo.setCuenta(origen);
			deshacerCargo.setOperacion("devolucion");
			deshacerCargo.setFecha(new Date());
			ingresarDinero(deshacerCargo);
			return resultadoAbono;
		};
		filas += resultadoAbono;		return filas;
	}

	/**
	 * Devuelve los últimos 10 movimientos asociados a una cuenta
	 * @param idCuenta el id de la cuenta
	 * @return la lista de movimientos asociados
	 */
	@Override
	public List<Movimiento> fetchMovimientos(int idCuenta) {
//		return mRepo.findByIdCuenta(idCuenta);
//		return mRepo.mostrarUltimos(idCuenta, 5);
		return mRepo.mostrarUltimosPaginados(idCuenta, PageRequest.of(0, 10)).toList();
	}
	

}
