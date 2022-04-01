package com.ite.libreria_jmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.libreria_jmp.model.beans.Pedido;

public interface PedidoRepo extends JpaRepository<Pedido, Integer>{
	@Query("select p from Pedido p where p.usuario.username = ?1")
	public List<Pedido> findByIdUsuario(String username);
	
	@Query("select sum(lp.cantidad) from LineasPedido lp " +
			"join Pedido p on lp.pedido.idPedido = p.idPedido " +
			"where p.usuario.username = ?1")
	public Integer getTotalLibros(String username);
	
	@Query(value="select sum(precio_venta * cantidad) from lineas_pedido lp " +
			"join pedidos p on lp.id_pedido = p.id_pedido " +
			"where p.username = ?1", nativeQuery=true)
	public Double getTotalPagos(String username);
}
