package com.ite.libreria_jmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.libreria_jmp.model.beans.Tema;
import com.ite.libreria_jmp.repository.TemaRepo;

@Service
public class TemaSvc implements IntTemaSvc{
	
	@Autowired
	TemaRepo tRepo;

	/**
	 * Crea 5 temas en la bbdd
	 */
	@Override
	public void inicializarTemas() {
		for (int i = 1; i <= 5; i++) {
			Tema tema = new Tema();
			String abreviatura = "tm" + i;
			String descTema = "Este es un tema " + i;
			
			tema.setAbreviatura(abreviatura);
			tema.setDescTema(descTema);
			tRepo.save(tema);
		}		
	}

	@Override
	public List<Tema> fetchAll() {
		return tRepo.findAll();
	}

	@Override
	public Tema findById(int idTema) {
		return tRepo.findById(idTema).orElse(null);
	}
	
	@Override
	public Tema findByAbreviatura(String abreviatura) {
		return tRepo.findByAbreviatura(abreviatura);
	}

	@Override
	public Tema findByDescripcion(String descripcion) {
		return tRepo.findByDescripcion(descripcion);
	}

	@Override
	public int insertOne(Tema tema) {
		if (tRepo.findByAbreviatura(tema.getAbreviatura()) != null
				|| tRepo.findByDescripcion(tema.getDescTema()) != null) return 0;
		int filas = 0;
		try {
			tRepo.save(tema);
			filas ++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}



}
