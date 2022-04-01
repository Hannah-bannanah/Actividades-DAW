package com.ite.proyectos.modelo.service;

import java.util.List;

import com.ite.proyectos.modelo.bean.Cliente;

public interface IntClienteSvc {
	List<Cliente> fetchAll();
	Cliente findByCif(String cif);
}
