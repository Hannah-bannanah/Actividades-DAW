package com.ite.cpe.modelo.dao;

import java.util.List;

import com.ite.cpe.modelo.beans.Cliente;

public interface IntClienteDao {
	List<Cliente> fetchAll();
}
