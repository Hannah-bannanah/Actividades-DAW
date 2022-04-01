package com.ite.cajero_rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.cajero_rest.model.beans.Cuenta;
import com.ite.cajero_rest.model.beans.Movimiento;
import com.ite.cajero_rest.model.dto.TransferenciaDTO;
import com.ite.cajero_rest.service.IntCuentaSvc;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private IntCuentaSvc csvc;
	
	@GetMapping("")
	public List<Cuenta> mostrarCuentas() {
		return csvc.fetchAll();
	}
	
	@GetMapping("/{idCuenta}")
	public Cuenta mostrarUna(@PathVariable("idCuenta") int idCuenta) {
		return csvc.findById(idCuenta);
	}
	
	@PostMapping("/{idCuenta}/extraer")
	public ResponseEntity<?> ingresar(@RequestBody Movimiento mov, @PathVariable("idCuenta") int idCuenta) {
		Cuenta cuenta = csvc.findById(idCuenta);
		if (cuenta == null) return ResponseEntity.badRequest().body("Bad Request");
		if (mov.getCantidad() <= 0) return ResponseEntity.badRequest().body("operacion no permitida");
		
		mov.setFecha(new Date());
		mov.setCuenta(cuenta);
		mov.setOperacion("cargo");
		
		int resultado = csvc.extraer(mov);
		switch (resultado) {
		case 0:
			return ResponseEntity.internalServerError().body("error al procesar la extraccion");
		case -1:
			return ResponseEntity.badRequest().body("Saldo insuficiente");
		default:
			return ResponseEntity.ok(mov);
		}
		
	}
	
	@PostMapping("/{idCuenta}/ingresar")
	public ResponseEntity<?> extraer(@RequestBody Movimiento mov, @PathVariable("idCuenta") int idCuenta) {
		Cuenta cuenta = csvc.findById(idCuenta);
		if (cuenta == null) return ResponseEntity.badRequest().body("{Bad Request");
		if (mov.getCantidad() <= 0) return ResponseEntity.badRequest().body("operacion no permitida");
		
		mov.setFecha(new Date());
		mov.setCuenta(cuenta);
		mov.setOperacion("abono");
		
		int resultado = csvc.ingresar(mov); 
		if (resultado == 0)
			return ResponseEntity.internalServerError().body("error al procesar el ingreso");
		else 
			return ResponseEntity.ok(mov);
	}
	
//	@PostMapping("/transferencia")
//	public ResponseEntity<?> realizarTransferencia(@RequestBody Map<String, String> transferencia){
////		System.out.println(transferencia.getClass());
//		Cuenta origen;
//		Cuenta destino;
//		int cantidad;
//		try {
//			int idOrigen = Integer.parseInt(transferencia.get("origen"));
//			origen = csvc.findById(idOrigen);
//			int idDestino = Integer.parseInt(transferencia.get("destino"));
//			destino = csvc.findById(idDestino);
//			cantidad = Integer.parseInt(transferencia.get("cantidad"));
//			if (cantidad <= 0 || origen.equals(destino)) return ResponseEntity.badRequest().body("{'error': 'operacion no permitida'}");
//		} catch (NumberFormatException e) {
//			return ResponseEntity.badRequest().body("{'error': 'Bad Request'}");
//		} catch (Exception e) {
//			return ResponseEntity.unprocessableEntity().body(e);
//		}
//		if (origen == null || destino == null)
//			return ResponseEntity.badRequest().body("{'error': 'Bad Request'}");
//		int resultado = csvc.realizarTransferencia(origen, destino, cantidad);
//		
//		switch (resultado) {
//		case 0:
//			return ResponseEntity.internalServerError().body("{'error': 'error al procesar la transferencia'}");
//		case -1:
//			return ResponseEntity.badRequest().body("{'error': 'Saldo insuficiente'}");
//		default:
//			return ResponseEntity.ok(csvc.findById(origen.getIdCuenta()));
//		}
//	}
	
//	@PostMapping("/transferencia")
//	public ResponseEntity<?> realizarTransferencia(@RequestBody TransferenciaDTO transferencia){
////		System.out.println(transferencia.getClass());
//		Cuenta origen;
//		Cuenta destino;
//		int cantidad;
//		origen = csvc.findById(transferencia.getIdOrigen());
//		destino = csvc.findById(transferencia.getIdDestino());
//		cantidad = transferencia.getCantidad();
//		
//		if (cantidad <= 0 || origen.equals(destino))
//			return ResponseEntity.badRequest().body("operacion no permitida");
//
//		if (origen == null || destino == null)
//			return ResponseEntity.badRequest().body("Bad Request");
//		
//		int resultado = csvc.realizarTransferencia(origen, destino, cantidad);
//		
//		switch (resultado) {
//		case 0:
//			return ResponseEntity.internalServerError().body("error al procesar la transferencia");
//		case -1:
//			return ResponseEntity.badRequest().body("saldo insuficiente");
//		default:
//			return ResponseEntity.ok(csvc.findById(origen.getIdCuenta()));
//		}
//	}
	
	@PostMapping("/transferencia")
	public String realizarTransferencia(@RequestBody TransferenciaDTO transferencia){
//		System.out.println(transferencia.getClass());
		Cuenta origen;
		Cuenta destino;
		int cantidad;
		origen = csvc.findById(transferencia.getIdOrigen());
		destino = csvc.findById(transferencia.getIdDestino());
		cantidad = transferencia.getCantidad();
		
		if (cantidad <= 0 || origen.equals(destino))
			return "operacion no permitida";

		if (origen == null || destino == null)
			return "Bad request";
		
		int resultado = csvc.realizarTransferencia(origen, destino, cantidad);
		if (resultado > 2)
			return "transferencia realizada con exito";
		else return "error en la operacion";
		
	}
	
	/**
	 * Muestra los movimientos de la cuenta del usuario
	 */
	@GetMapping("/{idCuenta}/movimientos")
	public List<Movimiento> mostrarMovimientos(@PathVariable("idCuenta") int idCuenta) {
		return csvc.fecthMovimientos(idCuenta);
	}
	
}
