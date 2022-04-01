/**
 * 
 */
package com.ite.fabrica_jdbc.modelo.dao;

import java.util.List;

import com.ite.fabrica_jdbc.modelo.beans.Usuario;

/**
 * @author hannah
 *
 */
public interface IntGestionUsuario {
	
	List<Usuario> findAll();
	Usuario findById(String username);
	Usuario findByIdAndPassword(String username, String password);
	int insertOne(Usuario usuario);
	int borrarUno(String username);
}
