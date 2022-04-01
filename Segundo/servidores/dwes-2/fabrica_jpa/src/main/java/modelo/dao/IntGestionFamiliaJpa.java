package modelo.dao;

import java.util.List;

import modelo.beans.Familia;

public interface IntGestionFamiliaJpa {
	Familia findById(int idFamilia);
	List<Familia> fetchAll();
	int insertOne(Familia familia);
	int update(Familia familia);
	int removeById(int idFamilia);
}
