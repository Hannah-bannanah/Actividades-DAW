package com.ite.libreria_jmp.service;

import java.util.List;

import com.ite.libreria_jmp.model.beans.Perfil;

public interface IntPerfilSvc {
	void inicializarPerfiles();
	List<Perfil> fetchAll();
	Perfil buscarPorDescripcion(String descripcion);
	Perfil findById(int idPerfil);
	int insertOne(Perfil perfil);
}
