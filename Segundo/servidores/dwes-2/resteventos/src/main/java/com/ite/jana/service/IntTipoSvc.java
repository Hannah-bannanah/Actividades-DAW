package com.ite.jana.service;

import java.util.List;

import com.ite.jana.model.beans.Tipo;

public interface IntTipoSvc {
	List<Tipo> fetchAll();
	Tipo findRandom();
	Tipo findById(int idTipo);
}
