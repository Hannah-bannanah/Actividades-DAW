package com.ite.proyectos.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.proyectos.modelo.bean.Perfil;
import com.ite.proyectos.modelo.repository.IntPerfilRepo;

@Service
public class ImplPerfilSvc implements IntPerfilSvc{
	@Autowired
	private IntPerfilRepo iPerfiles;

	@Override
	public List<Perfil> fetchAll() {
		return iPerfiles.fetchAll();
	}

	@Override
	public Perfil findById(int idPerfil) {
		return iPerfiles.findById(idPerfil);
	}
	
}
