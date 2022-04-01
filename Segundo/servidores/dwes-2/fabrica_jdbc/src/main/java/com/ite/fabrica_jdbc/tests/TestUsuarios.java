package com.ite.fabrica_jdbc.tests;

import java.util.List;

import com.ite.fabrica_jdbc.modelo.beans.Usuario;
import com.ite.fabrica_jdbc.modelo.dao.GestionUsuariosImplMysql8;
import com.ite.fabrica_jdbc.modelo.dao.IntGestionUsuario;

public class TestUsuarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntGestionUsuario udao = new GestionUsuariosImplMysql8();
		System.out.println(udao.findById("tomas"));
		List<Usuario> usuarios = udao.findAll();
		for (Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
	}

}
