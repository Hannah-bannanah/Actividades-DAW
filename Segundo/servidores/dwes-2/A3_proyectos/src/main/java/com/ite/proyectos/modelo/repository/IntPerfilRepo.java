package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.Perfil;

public interface IntPerfilRepo {
	List<Perfil> fetchAll();
	Perfil findById(int idPerfil);
}
