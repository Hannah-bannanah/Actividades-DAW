package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Perfil;

@Repository
public class ImplPerfilRepo implements IntPerfilRepo{
	
	private List<Perfil> perfiles;
	
	public ImplPerfilRepo() {
		perfiles = new ArrayList<Perfil>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("cargando datos perfil");
		perfiles.add(new Perfil(1, "Control de Gestion"));
		perfiles.add(new Perfil(2, "Jefe de Proyeto"));
		perfiles.add(new Perfil(3, "Operativo"));
		perfiles.add(new Perfil(4, "Recursos Humanos"));
	}

	@Override
	public List<Perfil> fetchAll() {
		return perfiles;
	}

	@Override
	public Perfil findById(int idPerfil) {
		for (Perfil perfil : perfiles) {
			if (perfil.getIdPerfil() == idPerfil) return perfil;
		}
		return null;
	}

}
