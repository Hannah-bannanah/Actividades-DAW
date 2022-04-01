package com.ite.eventos.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.eventos.modelo.bean.Cliente;
import com.ite.eventos.modelo.repository.IntClienteRepo;

@Service
public class ClienteServiceImpl implements IntClienteService{
	
	@Autowired
	private IntClienteRepo iClientes;

	@Override
	public List<Cliente> fetchAll() {
		return iClientes.fetchAll();
	}

	@Override
	public int login(String username, String password) {
		Cliente cliente = iClientes.findByUsername(username);
		return cliente != null && cliente.getPassword().equals(password) ? 1 : 0;
	}

	@Override
	public int altaCliente(Cliente cliente) {
		Cliente clienteExistente = iClientes.findByUsername(cliente.getUsername());
		if (clienteExistente != null)
			return 0;
		else
			return iClientes.altaCliente(cliente);		
	}

	@Override
	public Cliente findByUsername(String username) {
		return iClientes.findByUsername(username);
	}

	@Override
	public Cliente findById(int idCliente) {
		return iClientes.findById(idCliente);
	}

}
