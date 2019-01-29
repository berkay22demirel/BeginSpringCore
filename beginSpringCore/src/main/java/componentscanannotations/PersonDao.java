package componentscanannotations;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

	public void insert(Person person) {

		System.out.println("Dao Layer");
		System.out.println(person);
	}

}
