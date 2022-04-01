package com.ite.cajero_rest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ite.cajero_rest.model.beans.Cuenta;
import com.ite.cajero_rest.service.IntCuentaSvc;

@CrossOrigin(origins = "*") 
@RestController
public class HomeController {
	
	@Autowired
	private IntCuentaSvc csvc;
	
	@Autowired
	ObjectMapper om;

	
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody Cuenta cuentaAValidar, HttpSession sesion) {
//		
//		Cuenta cuenta = csvc.validarCuenta(cuentaAValidar.getIdCuenta());		
//
//		if (cuenta != null) {
//			sesion.setAttribute("cuenta", cuenta);
//			return ResponseEntity.ok(cuenta);
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error' : 'Bad Request'}");
//	}
	
	@PostMapping("/login")
	public Cuenta login(@RequestBody Cuenta cuentaAValidar, HttpSession sesion) {
		return csvc.validarCuenta(cuentaAValidar.getIdCuenta());		
	}	
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion){
		sesion.invalidate();
		return "{'success' : 1}";
	}
}
