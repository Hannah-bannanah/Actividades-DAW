package modelo.dao;

import javax.persistence.*;

public abstract class AbstractFactory {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected String sql;
	protected Query query;
	
	public AbstractFactory() {
		emf = Persistence.createEntityManagerFactory("fabrica_jpa");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
}
