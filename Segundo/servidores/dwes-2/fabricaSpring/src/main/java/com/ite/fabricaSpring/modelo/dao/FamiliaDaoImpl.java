package com.ite.fabricaSpring.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.fabricaSpring.modelo.beans.Familia;
import com.ite.fabricaSpring.modelo.repository.IntFamiliaRepo;

@Service
public class FamiliaDaoImpl implements IntFamiliaDao{

	@Autowired
	private IntFamiliaRepo frepo;

	@Override
	public List<Familia> findAll() {
		return frepo.findAll();
	}
}
