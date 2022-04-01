package com.ite.cpe.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.cpe.modelo.beans.Cliente;
import com.ite.cpe.modelo.repository.IntClienteRepo;

@Service
public class ClienteDaoImpl implements IntClienteDao{

	@Autowired
	private IntClienteRepo cRepo;

	@Override
	public List<Cliente> fetchAll() {
		return cRepo.findAll();
	}

}
