package com.ite.libreria_jmp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.libreria_jmp.model.beans.LineasPedido;
import com.ite.libreria_jmp.model.beans.Pedido;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.repository.PedidoRepo;
import com.ite.libreria_jmp.util.LineaCarrito;

@Service
public class PedidoSvc implements IntPedidoSvc{
	
	@Autowired PedidoRepo pedRepo;
	
	@Override
	public List<Pedido> fetchAll(){
		return pedRepo.findAll();
	}
	
	@Override
	public Pedido findById(int idPedido) {
		return pedRepo.findById(idPedido).orElse(null);
	}

	@Override
	public int realizarPedido(Usuario usuario, List<LineaCarrito> lineas) {
		List<LineasPedido> lineasPedido = new ArrayList<LineasPedido>();
		Pedido pedido = new Pedido();
		
		//recorremos las lineas del carrito convirtiendolas en lineas de pedido
		for (LineaCarrito lc: lineas) {
			LineasPedido linea = new LineasPedido();
			linea.setCantidad(lc.getCantidad());
			linea.setFechaAlta(new Date());
			linea.setPrecioVenta(lc.getLibro().getPrecioUnitario());
			linea.setLibro(lc.getLibro());
			linea.setPedido(pedido);
			lineasPedido.add(linea);
		}
		
		pedido.setDireccionEntrega(usuario.getDireccion());
		pedido.setFechaAlta(new Date());
		pedido.setUsuario(usuario);
		pedido.setLineasPedidos(lineasPedido);
		pedido.setEstado("terminado");
		
		int filas = 0;
		try {
			pedRepo.save(pedido);
			filas = lineas.size() + 1;
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return filas;
	}

	@Override
	public List<Pedido> findByIdUsuario(String username) {
		return pedRepo.findByIdUsuario(username);
	}

	@Override
	public int getTotalLibros(String username) {
		return pedRepo.getTotalLibros(username) != null ? pedRepo.getTotalLibros(username) : 0;
	}

	@Override
	public double getTotalPagos(String username) {
		return pedRepo.getTotalPagos(username) != null ? pedRepo.getTotalPagos(username) : 0.0;
	}

}
