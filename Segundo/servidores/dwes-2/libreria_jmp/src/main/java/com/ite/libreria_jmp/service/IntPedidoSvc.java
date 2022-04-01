package com.ite.libreria_jmp.service;

import java.util.List;

import com.ite.libreria_jmp.model.beans.Pedido;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.util.LineaCarrito;

public interface IntPedidoSvc {
	List<Pedido> fetchAll(); 
	Pedido findById(int idPedido);
	int realizarPedido(Usuario usuario, List<LineaCarrito> lineas);
	List<Pedido> findByIdUsuario(String username);
	int getTotalLibros(String username);
	double getTotalPagos(String username);
}
