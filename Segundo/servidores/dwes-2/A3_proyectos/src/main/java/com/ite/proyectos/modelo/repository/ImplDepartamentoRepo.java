package com.ite.proyectos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.modelo.bean.Departamento;

@Repository
public class ImplDepartamentoRepo implements IntDepartamentoRepo {
	private List<Departamento> departamentos;
	
	public ImplDepartamentoRepo() {
		departamentos = new ArrayList<Departamento>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		System.out.println("cargando datos dpto");
		departamentos.add(new Departamento(1, "remoto", "Ventas", null));
		departamentos.add(new Departamento(2, "remoto", "IT", null));
		departamentos.add(new Departamento(3, "remoto", "RRHH", null));
		departamentos.add(new Departamento(4, "remoto", "Finanzas", null));
	}

	@Override
	public List<Departamento> fetchAll() {
		return departamentos;
	}

	@Override
	public Departamento findById(int idDepar) {
		for (Departamento departamento : departamentos) {
			if (departamento.getIdDepar() == idDepar) {
				return departamento;
			}
		}
		return null;
	}
}
