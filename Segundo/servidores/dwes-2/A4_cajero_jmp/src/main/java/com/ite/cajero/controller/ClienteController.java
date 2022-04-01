/**
 * 
 */
package com.ite.cajero.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.cajero.modelo.beans.Cuenta;
import com.ite.cajero.modelo.beans.Movimiento;
import com.ite.cajero.modelo.dao.IntCuentaDao;
import com.ite.cajero.util.AccessValidator;

/**
 * Controlador de las acciones de cliente
 * @author hannah
 *
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	/* Para todas las url dentro del path de cliente, 
	 * validaremos si el usuario está logueado. En caso de que no
	 * redirigimos al usuario al path base, lo que muestra la pagina 
	 * de login
	 */
	@Autowired
	private AccessValidator av; 
	
	@Autowired
	private IntCuentaDao cDao;
	
	/**
	 * Reenvia la request al path /cliente/menu
	 */
	@GetMapping("")
	public String cliente() {
		return "forward:/cliente/menu";
	}
	
	/**
	 * Muestra el menu de cliente
	 */
	@GetMapping("/menu")
	public String mostrarMenu() {
		return "menu";
	}
	
	/**
	 * Muestra el formulario de extracción de dinero
	 */
	@GetMapping("/extraer")
	public String extraerDinero(Model model) {
		model.addAttribute("transaccion", "extraccion");
		return "transaccion";
	}
	
	/**
	 * Intenta extraer la cantidad establecida de la cuenta del usuario
	 * Si no hay suficiente saldo o si no se puede realizar
	 * la operación por otro motivo, se informa al usuario
	 * Si la operación se realiza con éxito, se redirige al usario
	 * al menu de cliente
	 */
	@PostMapping("/extraccion")
	public String extraerDinero(Movimiento movimiento, RedirectAttributes attr,
			HttpSession sesion) {
		movimiento.setFecha(new Date());
		movimiento.setCuenta((Cuenta)sesion.getAttribute("cuenta"));
		
		int resultadoOperacion = cDao.extraerDinero(movimiento);
		String mensaje;
		
		if (resultadoOperacion == -1) {
			mensaje = "Saldo insufciente";
			attr.addFlashAttribute("mensajeError", mensaje);
		} else if (resultadoOperacion > 0) {
			mensaje = "Operaci&oacute;n realizada con &eacute;xito.";
			mensaje += "\nSaldo: " + movimiento.getCuenta().getSaldo();
			attr.addFlashAttribute("mensajeExito", mensaje);
			return "redirect:/cliente/menu"; 
		} else {
			mensaje = "No se ha podido realizar la operaci&oacute;n";
			mensaje += "\nSaldo: " + movimiento.getCuenta().getSaldo();
			attr.addFlashAttribute("mensajeError", mensaje);
		}
		
		return "redirect:/cliente/extraer";
	}
		
	/**
	 * Muestra el formulario de ingreso
	 */
	@GetMapping("/ingresar")
	public String mostrarIngresarDinero(Model model) {
		model.addAttribute("transaccion", "ingreso");
		return "transaccion";
	}
	
	/**
	 * Ingresa la cantidad establecida en la cuenta del usuario
	 */
	@PostMapping("/ingreso")
	public String ingresarDinero(Movimiento movimiento, RedirectAttributes attr,
			HttpSession sesion) {
		movimiento.setFecha(new Date());
		movimiento.setCuenta((Cuenta) sesion.getAttribute("cuenta"));
		String mensaje;
		if (cDao.ingresarDinero(movimiento) > 0) {
			mensaje = "Operaci&oacute;n realizada con &eacute;xito.";
			mensaje += "\nSaldo: " + movimiento.getCuenta().getSaldo();
			attr.addFlashAttribute("mensajeExito", mensaje);
		} else {
			mensaje = "No se ha podido realizar la operaci&oacute;n";
			mensaje += "\nSaldo: " + movimiento.getCuenta().getSaldo();
			attr.addFlashAttribute("mensajeError", mensaje);
		}
		return "redirect:/cliente/menu";
	}
	
	/**
	 * Muestra el formulario de transferencia
	 */
	@GetMapping("/transferencia")
	public String mostrarTransferencia() {
		return "transferencia";
	}
	
	/**
	 * Intenta realizar una transferencia desde la cuenta del usuario
	 * a la cuenta de destino establecida. 
	 * Si la cuenta de destino no existe o el saldo del usuario es
	 * insuficiente, se informa al usuario.
	 * Si la operación se realiza con éxito, se redirige al usuario
	 * al menu de cliente
	 */
	@PostMapping("/transferencia")
	public String realizarTransferencia(@RequestParam("destino") int idCuentaDestino, 
			@RequestParam("cantidad") int cantidad, HttpSession sesion,
			RedirectAttributes attr) {
		Cuenta origen = (Cuenta) sesion.getAttribute("cuenta");
		Cuenta destino = cDao.findById(idCuentaDestino);
		
		int resultadoOperacion = cDao.transferencia(origen, destino, cantidad);
		System.out.println("resultado de la operacion: " + resultadoOperacion);
		
		switch(resultadoOperacion) {
		case -2:
			attr.addFlashAttribute("mensajeError", "La cuenta de destino no existe");
			return "redirect:/cliente/transferencia";
		case -1: 
			attr.addFlashAttribute("mensajeError", "Saldo insuficiente");
			return "redirect:/cliente/transferencia";
		case 0:
			attr.addFlashAttribute("mensajeError", "Error al intentar realizar la operaci&oacute;n");
			return "redirect:/cliente/transferencia";
		default:
			String mensaje = "Operaci&oacute;n realizada con &eacute;xito.";
			mensaje += "\nSaldo: " + origen.getSaldo();
			attr.addFlashAttribute("mensajeExito", mensaje);
			return "redirect:/cliente/menu";
		}
	}
	
	/**
	 * Muestra los movimientos de la cuenta del usuario
	 */
	@GetMapping("/movimientos")
	public String mostrarMovimientos(Model model, HttpSession sesion) {
		Cuenta cuenta = (Cuenta) sesion.getAttribute("cuenta");
		model.addAttribute("listaMovimientos", cDao.fetchMovimientos(cuenta.getIdCuenta()));
		return "movimientos";
	}
}
