package tk.kwesidev.jpatutorials;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	private static final EntityManagerFactory emfactory;

	static {

		emfactory = Persistence.createEntityManagerFactory("jpatest");

	}
	private static EntityManager manager = null;

	public static void addDeveloper(String firstName, String lastName) {

		EntityTransaction tx = null;
		try {
			manager = emfactory.createEntityManager();
			tx = manager.getTransaction();
			tx.begin();

			Developer developer = new Developer(firstName, lastName);
			manager.persist(developer);
			manager.flush();
			tx.commit();

		} catch (Exception e) {

			if (tx.isActive() && tx != null) {

				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			manager.close();
			emfactory.close();
		}
	}

	public static void assignProject(Integer developerId, String projectTitle) {

		EntityTransaction tx = null;
		try {
			manager = emfactory.createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			Developer developer = manager.find(Developer.class, developerId);
			Project project = new Project(projectTitle);
			developer.addProject(project);
			manager.persist(developer);
			manager.persist(project);
			manager.flush();
			tx.commit();

		} catch (Exception e) {

			if (tx.isActive() && tx != null) {

				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			manager.close();
			emfactory.close();
		}

	}

	public static void listDevelopers() {
		try {
			manager = emfactory.createEntityManager();
			List<Developer> developers = manager.createQuery("SELECT d FROM Developer d", Developer.class)
					.getResultList();
			for (Developer developer : developers) {

				System.out.println("FirstName:" + developer.getFirstName() + ",LastName:" + developer.getLastName());
				System.out.println("Projects");
				for (Project project : developer.getProjects()) {
					System.out.println("Project Title :" + project.getTitle());
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			manager.close();
			emfactory.close();
		}

	}

	public static void main(String[] args) throws java.io.FileNotFoundException, IOException {
		// addDeveloper("Jacky","Smith");
		// assignProject(11, "Mobile App for Insurance");
		listDevelopers();
	}
}
