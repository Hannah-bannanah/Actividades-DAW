package com.ite.fabricaSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ite.fabricaSpring.modelo.beans.Producto;
import com.ite.fabricaSpring.modelo.dao.IntProductoDao;
import com.ite.fabricaSpring.modelo.repository.IntProductoRepo;

@Controller
public class HomeController {

	@Autowired
	private IntProductoDao pdao;
	
	@GetMapping("/")
	public String procInicioProductos(Model model) {
		return "forward:/productos";
	}

}
