package com.ite.libreria_jmp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.libreria_jmp.model.beans.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, String>{
	@Query(value = "select * from Usuarios u " + 
			"inner join Usuario_Perfiles up on u.username = up.username " +
			"inner join Perfiles p on p.id_perfil = up.id_perfil " +
			"where p.descripcion = ?1", nativeQuery = true)
	public List<Usuario> findByPerfil(String descripcion);
}
