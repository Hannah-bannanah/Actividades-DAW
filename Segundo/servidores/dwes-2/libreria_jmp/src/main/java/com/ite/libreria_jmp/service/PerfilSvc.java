package com.ite.libreria_jmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.libreria_jmp.model.beans.Perfil;
import com.ite.libreria_jmp.repository.PerfilRepo;

@Service
public class PerfilSvc implements IntPerfilSvc{
	
	@Autowired
	private PerfilRepo perfRepo;

	/**
	 * Crea dos perfiles en la base de datos:
	 * - 'ROL_ADMON'
	 * - 'ROL_CLIENTE'
	 */
	@Override
	public void inicializarPerfiles() {
		Perfil admon = new Perfil();
		admon.setDescripcion("ROL_ADMON");
		Perfil cliente = new Perfil();
		cliente.setDescripcion("ROL_CLIENTE");
		perfRepo.save(admon);
		perfRepo.save(cliente);
		
	}
	
	@Override
	public List<Perfil> fetchAll(){
		return perfRepo.findAll();
	}

	@Override
	public Perfil buscarPorDescripcion(String descripcion) {
		return perfRepo.buscarPorDescripcion(descripcion);
	}
	
	@Override
	public Perfil findById(int idPerfil) {
		return perfRepo.findById(idPerfil).orElse(null);
	}

	@Override
	public int insertOne(Perfil perfil) {
		if (findById(perfil.getIdPerfil()) != null ||
				buscarPorDescripcion(perfil.getDescripcion()) != null) return 0;
		int filas = 0;
		
		try {
			perfRepo.save(perfil);
			filas++;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	

}
