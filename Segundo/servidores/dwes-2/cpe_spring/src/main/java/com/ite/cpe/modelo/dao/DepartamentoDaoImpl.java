package com.ite.cpe.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.cpe.modelo.beans.Departamento;
import com.ite.cpe.modelo.repository.IntDepartamentoRepo;

@Service
public class DepartamentoDaoImpl implements IntDepartamentoDao{
	@Autowired
	private IntDepartamentoRepo dRepo;

	@Override
	public List<Departamento> fetchAll() {
		return dRepo.findAll();
	}
	
	

}
