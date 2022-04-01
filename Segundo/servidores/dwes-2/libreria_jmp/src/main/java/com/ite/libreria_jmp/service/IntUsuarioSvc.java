package com.ite.libreria_jmp.service;

import java.util.List;

import com.ite.libreria_jmp.model.beans.Usuario;

public interface IntUsuarioSvc {
	void iniciaLizarUsuarios();
	List<Usuario> fetchAll();
	Usuario findById(String username);
	List<Usuario> findByProfileDescription(String descripcion);
	int insertOne(Usuario usuario);
}
