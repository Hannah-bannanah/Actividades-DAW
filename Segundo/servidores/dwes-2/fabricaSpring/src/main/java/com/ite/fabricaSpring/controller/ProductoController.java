package com.ite.fabricaSpring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.fabricaSpring.modelo.beans.Familia;
import com.ite.fabricaSpring.modelo.beans.Producto;
import com.ite.fabricaSpring.modelo.dao.IntFamiliaDao;
import com.ite.fabricaSpring.modelo.dao.IntProductoDao;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IntProductoDao pdao;
	@Autowired
	private IntFamiliaDao fdao;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@GetMapping("")
	public String mostrarProductos(Model model) {
		List<Producto> productos = pdao.findAll();
		model.addAttribute("listaProductos", productos);
		return "listaProductos";
	}
	
	@GetMapping("/alta")
	public String getAltaProducto(Model model) {
		List<Familia> familias = fdao.findAll();
		model.addAttribute("familias", familias);
		
		return "postProducto";
	}
	
	@PostMapping("/alta")
	public String altaProducto(Producto producto, RedirectAttributes attr) {
		producto.setFechaAlta(new Date());
		 if (pdao.insertOne(producto) == 1)
			 attr.addFlashAttribute("mensaje", "producto a&ntilde;adido con &eacute;xito");
		 else
			 attr.addFlashAttribute("mensaje", "el producto no se ha podido a&ntilde;adir");
		
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String getEditarProducto (@PathVariable("id") int idProducto, Model model) {
		Producto producto = pdao.findById(idProducto);
		model.addAttribute("producto", producto);
		
		List<Familia> familias = fdao.findAll();
		model.addAttribute("familias", familias);
		
		return "postProducto";
	}
	
	@PostMapping("/editar/{id}")
	public String editarProducto (Producto producto, RedirectAttributes attr) {
		if (pdao.update(producto) == 1)
			attr.addFlashAttribute("mensaje", "el producto se ha actualizado con &eacute;xito");
		else 
			attr.addFlashAttribute("mensaje", "el producto no se ha actualizado");
		return "redirect:/";
	}
	
	@GetMapping("/eliminar")
	public String eliminarProducto (@RequestParam("idProducto") int idProducto, Model model) {
		if (pdao.eliminarProducto(idProducto) == 1) 
			model.addAttribute("mensaje", "el producto se ha eliminado con exito");
		else
			model.addAttribute("mensaje", "el producto no se ha eliminado");
		return "forward:/";
	}

	@GetMapping("/listarPorFamilia/{id}")
	public String listarPorFamilia(@PathVariable("id") int idFamilia) {
		System.out.println(pdao.findByFamilia(idFamilia));
		return "demoPage";
	}
}
