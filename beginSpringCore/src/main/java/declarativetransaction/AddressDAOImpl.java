package declarativetransaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Address address) {
		
		entityManager.persist(address);
	}

}
