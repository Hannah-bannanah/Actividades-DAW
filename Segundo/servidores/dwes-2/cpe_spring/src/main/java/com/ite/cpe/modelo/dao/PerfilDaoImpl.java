package com.ite.cpe.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.cpe.modelo.beans.Perfil;
import com.ite.cpe.modelo.repository.IntPerfilRepo;

@Service
public class PerfilDaoImpl implements IntPerfilDao {
	
	@Autowired
	private IntPerfilRepo pRepo;

	@Override
	public List<Perfil> fetchAll() {
		return pRepo.findAll();
	}


}
