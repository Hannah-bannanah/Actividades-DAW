package com.ite.proyectos.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.proyectos.modelo.bean.Cliente;
import com.ite.proyectos.modelo.repository.IntClienteRepo;

@Service
public class ImplClienteSvc implements IntClienteSvc{
	
	@Autowired
	IntClienteRepo iClientes;

	@Override
	public List<Cliente> fetchAll() {
		return iClientes.fetchAll();
	}

	@Override
	public Cliente findByCif(String cif) {
		return iClientes.findByCif(cif);
	}
	
}
