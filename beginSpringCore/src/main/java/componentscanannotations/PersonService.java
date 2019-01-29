package componentscanannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public void insertPerson(Person person) {

		System.out.println("Service Layer");
		personDao.insert(person);
	}

}
