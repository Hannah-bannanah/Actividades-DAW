package com.ite.eventos.modelo.repository;

import java.util.List;

import com.ite.eventos.modelo.bean.Cliente;

/**
 * Interfaz que contiene los metodos del repositorio simulado de Cliente
 * @author hannah
 *
 */
public interface IntClienteRepo {
	
	List<Cliente> fetchAll();
	int altaCliente(Cliente cliente);
	Cliente findByUsername(String username);
	Cliente findById(int idCliente);
}
