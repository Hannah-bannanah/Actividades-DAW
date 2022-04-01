package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.Cliente;

public interface IntClienteRepo {
	List<Cliente> fetchAll();
	Cliente findByCif(String cif);
}
