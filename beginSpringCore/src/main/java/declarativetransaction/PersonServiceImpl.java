package declarativetransaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private AddressDAO addressDAO;

	@Transactional
	public void insertPerson(Person3 person) {

		personDAO.insert(person);
		addressDAO.insert(person.getAddress());

	}

	@Transactional(readOnly = true)
	public List<Person3> getAllPerson() {

		return personDAO.findAll();
	}

}
