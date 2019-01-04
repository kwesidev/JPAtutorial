package tk.kwesidev.jpatutorials;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
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