package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Familia;

public class GestionFamiliaImplJpa extends AbstractFactory implements IntGestionFamiliaJpa {

	public GestionFamiliaImplJpa() {
		super();
	}

	@Override
	public Familia findById(int idFamilia) {
		Familia familia = em.find(Familia.class, idFamilia);
		return familia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> fetchAll() {
		sql = "select f from Familia f";
		query = em.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public int insertOne(Familia familia) {
		int filasInsertadas = 0;
//		em.getTransaction().begin();
		tx.begin();
		try {
			em.persist(familia);
			filasInsertadas = 1;
//			em.getTransaction().commit();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filasInsertadas;
	}

	@Override
	public int update(Familia familia) {
		int filasModificadas = 0;
		em.getTransaction().begin();
		try {
			em.merge(familia);
			filasModificadas = 1;
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filasModificadas;
	}

	@Override
	public int removeById(int idFamilia) {
		em.getTransaction().begin();
		int filasAfectadas = 0;
		Familia familia = findById(idFamilia);
		try {
			if (familia != null) {
				em.remove(familia);
				filasAfectadas = 1;
				em.getTransaction().commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return filasAfectadas;
	}

}
