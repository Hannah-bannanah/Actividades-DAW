package com.ite.eventos.modelo.services;

import java.util.List;

import com.ite.eventos.modelo.bean.Cliente;

public interface IntClienteService {
	
	List<Cliente> fetchAll();
	int login(String username, String password);
	int altaCliente(Cliente cliente);
	Cliente findByUsername(String username);
	Cliente findById(int idCliente);
}
