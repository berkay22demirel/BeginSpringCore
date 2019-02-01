package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("personDAOImpl")
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public void insert(Person person) {

		Session session = getSession();
		Transaction transacion = session.beginTransaction();
		session.persist(person);
		transacion.commit();
		session.close();

	}

	public Person getPersonById(int id) {

		Session session = getSession();
		Person person = session.get(Person.class, id);
		session.close();
		return person;
	}

	public List<Person> getAllPersons() {
		
		Session session = getSession();
		TypedQuery<Person> query = session.createQuery("Select e from Person e",Person.class);
		return query.getResultList();
	}

	public void update(Person person) {

		Session session = getSession();
		Transaction transacion = session.beginTransaction();
		session.update(person);
		transacion.commit();
		session.close();

	}

	public void delete(Person person) {

		if (person != null) {
			Session session = getSession();
			Transaction transacion = session.beginTransaction();
			session.delete(person);
			transacion.commit();
			session.close();
		}

	}


}
