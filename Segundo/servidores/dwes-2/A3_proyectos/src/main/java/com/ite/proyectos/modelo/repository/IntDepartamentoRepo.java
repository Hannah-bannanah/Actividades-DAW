package com.ite.proyectos.modelo.repository;

import java.util.List;

import com.ite.proyectos.modelo.bean.Departamento;

public interface IntDepartamentoRepo {
	List<Departamento> fetchAll();
	Departamento findById(int idDepar);
}
