package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class PersonDAOImpl implements PersonDAO {

	private EntityManager entityManager;

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void insert(Person person) {

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
	}

	public Person getPersonById(int id) {

		return entityManager.find(Person.class, id);
	}

	public List<Person> getAllPersons() {
		
		TypedQuery<Person> query = entityManager.createQuery("Select e from Person e", Person.class);
		return query.getResultList();
	}

	public void update(Person person) {

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();

	}

	public void delete(Person person) {
		if (person != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(person);
			entityManager.getTransaction().commit();
		}

	}


}
