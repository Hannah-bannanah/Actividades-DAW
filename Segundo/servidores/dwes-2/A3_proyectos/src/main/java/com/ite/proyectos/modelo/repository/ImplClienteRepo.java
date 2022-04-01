package com.ite.proyectos.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Cliente;

@Repository
public class ImplClienteRepo implements IntClienteRepo {
	
	private List<Cliente> clientes;
	public ImplClienteRepo() {
		clientes = new ArrayList<Cliente>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("Cargando datos cliente");
		for (int i = 0; i < 10; i++) {
			String cif = "cliente#" + i;
			String domicilio = "casa" + 1;
			BigDecimal facturacionAnial = new BigDecimal(1000000 / (i + 1));
			String nombre = "Sr Cliente " + i;
			int numeroEmpleados = (i + 1) * 25;
			Cliente cliente = new Cliente(cif, domicilio, facturacionAnial, nombre, numeroEmpleados);
			clientes.add(cliente);
		}
	}

	@Override
	public List<Cliente> fetchAll() {
		return clientes;
	}

	@Override
	public Cliente findByCif(String cif) {
		for (Cliente cliente: clientes) {
			if (cliente.getCif().equals(cif))
				return cliente;
		}
		return null;
	}
	
}
