/**
 * 
 */
package com.ite.cajero.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.cajero.modelo.beans.Cuenta;
import com.ite.cajero.modelo.dao.IntCuentaDao;

/**
 * @author hannah
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private IntCuentaDao cDao;
	
	/**
	 * Muestra la pagina de login
	 */
	@GetMapping("/")
	public String mostrarLogin() {
		return "login";
	}
	
	/**
	 * Verifica que la cuenta existe y la añade como atributo de sesion
	 * Redirige al usuario al menu de cliente si la cuenta existe, 
	 * a la pagina de login si no
	 */
	@PostMapping("/login")
	public String login(@RequestParam("idCuenta") int idCuenta, RedirectAttributes attr,
			HttpSession sesion) {
		Cuenta cuenta = cDao.validarCuenta(idCuenta);
		if (cuenta != null) {
			sesion.setAttribute("cuenta", cuenta); //guardamos solo el id porque la cuenta va a sufrir modificaciones 
			return "redirect:/cliente";
		} else {
			attr.addFlashAttribute("mensajeError", "N&uacute;mero de cuenta no v&aacute;lido");
			return "redirect:/";
		}
	}
	
	/**
	 * Cierra la sesion de usuario y redirige al usuario a la pagina
	 * de login
	 */
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
}
