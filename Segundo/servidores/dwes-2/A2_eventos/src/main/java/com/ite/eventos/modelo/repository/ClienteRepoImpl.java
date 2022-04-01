
/**
 * 
 */
package com.ite.eventos.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.bean.Cliente;

/**
 * Clase que implementa los metodos del repositorio de Cliente
 * @author hannah
 *
 */
@Repository
public class ClienteRepoImpl implements IntClienteRepo{
	
	private List<Cliente> clientes;

	/**
	 * Constructor
	 */
	public ClienteRepoImpl() {
		clientes = new ArrayList<Cliente>();
		
		cargarDatos();	
	}
	
	private void cargarDatos() {
		//inicializamos con un solo cliente
		String username = "hannah";
		String password = "supersecreta";
		String email = "hannah@bannanah.com";
		String nombre = "Jana";
		String direccion = "Mi casa";
		Cliente cliente0 = new Cliente(username, password, email, nombre, direccion, 1, new Date());
		clientes.add(cliente0);
	}

	@Override
	public int altaCliente(Cliente cliente) {
		return clientes.add(cliente) ? 1 : 0;
	}

	@Override
	public Cliente findByUsername(String username) {
		for (Cliente cliente : clientes) {
			if (cliente.getUsername().equals(username)) return cliente;
		}
		return null;
	}

	@Override
	public List<Cliente> fetchAll() {
		return clientes;
	}

	@Override
	public Cliente findById(int idCliente) {
		for (Cliente cliente : clientes) {
			if (cliente.getIdCliente() == idCliente) return cliente;
		}
		return null;
	}

}
