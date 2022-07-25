package com.github.kwesidev.jpatutorials;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class DBManager {
	private EntityManagerFactory emfactory;
	public DBManager() {
		emfactory = Persistence.createEntityManagerFactory("jpatest");
	}
	/**
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return emfactory.createEntityManager();
	}

}