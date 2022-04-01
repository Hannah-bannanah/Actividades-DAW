package com.ite.proyectos.modelo.service;

import java.util.List;

import com.ite.proyectos.modelo.bean.Perfil;

public interface IntPerfilSvc {
	List<Perfil> fetchAll();
	Perfil findById(int idPerfil);
}
