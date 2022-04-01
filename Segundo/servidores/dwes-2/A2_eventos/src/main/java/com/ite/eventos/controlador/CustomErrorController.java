package com.ite.eventos.controlador;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de erroes
 * @author hannah bannanah
 *
 */
@Controller
public class CustomErrorController implements ErrorController{
	
	@GetMapping("/error")
	public String getError (RedirectAttributes atributos, Model model) {
		if (model.getAttribute("codigoError") != null) {
			return "errorCustomizado";
		}
		return "error404";
	}
}
