package declarativetransaction;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final String SELECT_ALL = "SELECT p FROM Person3 p";

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Person3 person) {

		entityManager.persist(person);
	}

	public List<Person3> findAll() {
		
		TypedQuery<Person3> query = entityManager.createQuery(SELECT_ALL, Person3.class);
		return query.getResultList();
	}


}
