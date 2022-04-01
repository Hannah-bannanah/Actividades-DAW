package com.ite.libreria_jmp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ite.libreria_jmp.model.beans.Perfil;
import com.ite.libreria_jmp.model.beans.Usuario;
import com.ite.libreria_jmp.repository.UsuarioRepo;

@Service
public class UsuarioSvc implements IntUsuarioSvc{
	
	@Autowired private IntPerfilSvc perfSvc;
	
	@Autowired private UsuarioRepo uRepo;
	
	@Autowired private BCryptPasswordEncoder pwe;

	/**
	 * Metodo que crea tres usuarios en la BBDD. <br>
	 * Requiere que existan dos perfiles, ROL_CLIENTE y ROL_ADMON
	 */
	@Override
	public void iniciaLizarUsuarios() {
		
		//crear cliente payasa
		Usuario cJana = new Usuario();
		cJana.setUsername("cjana");
		cJana.setApellido("marciana");
		cJana.setDireccion("calle falsa, 123");
		cJana.setEmail("cjana@marciana");
		cJana.setFechaAlta(new Date());
		cJana.setNombre("jana");
		cJana.setPassword(pwe.encode("cjana"));
		cJana.setEnabled(1);
		List<Perfil> perfilesCJana = new ArrayList<Perfil>();
		perfilesCJana.add(perfSvc.buscarPorDescripcion("ROL_CLIENTE"));
		cJana.setPerfiles(perfilesCJana);
		uRepo.save(cJana);
		
		//crear cliente admin erudito :P
		Usuario aTomas = new Usuario();
		aTomas.setUsername("atomas");
		aTomas.setApellido("sabemas");
		aTomas.setDireccion("Calle falsa, 123");
		aTomas.setEmail("atomas@sabemas");
		aTomas.setFechaAlta(new Date());
		aTomas.setNombre("atomas");
		aTomas.setPassword(pwe.encode("atomas"));
		aTomas.setEnabled(1);
		List<Perfil> perfilesATomas = new ArrayList<Perfil>();
		perfilesATomas.add(perfSvc.buscarPorDescripcion("ROL_ADMON"));
		aTomas.setPerfiles(perfilesATomas);
		uRepo.save(aTomas);
		
		//crear usuario con doble personalidad
		Usuario doble = new Usuario();
		doble.setUsername("doble");
		doble.setApellido("Redoble");
		doble.setDireccion("Calle falsa, 123");
		doble.setEmail("doble@redoble");
		doble.setFechaAlta(new Date());
		doble.setNombre("doble");
		doble.setPassword(pwe.encode("doble"));
		doble.setEnabled(1);
		List<Perfil> perfilesDoble = new ArrayList<Perfil>();
		perfilesDoble.add(perfSvc.buscarPorDescripcion("ROL_CLIENTE"));
		perfilesDoble.add(perfSvc.buscarPorDescripcion("ROL_ADMON"));
		doble.setPerfiles(perfilesDoble);
		uRepo.save(doble);
			
	}
	
	@Override
	public List<Usuario> fetchAll(){
		return uRepo.findAll();
	}

	@Override
	public Usuario findById(String username) {
		return uRepo.findById(username).orElse(null);
	}

	@Override
	public List<Usuario> findByProfileDescription(String descripcion) {
		return uRepo.findByPerfil(descripcion);
	}

	@Override
	public int insertOne(Usuario usuario) {
		if (findById(usuario.getUsername()) != null) return 0;
		int filas = 0;
		try {
			uRepo.save(usuario);
			filas++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
