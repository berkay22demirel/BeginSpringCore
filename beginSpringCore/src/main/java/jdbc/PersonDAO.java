package jdbc;

import java.util.List;

public interface PersonDAO {

	public int insert(PersonModel person);
	public PersonModel getPersonById(int id);
	public List<PersonModel> getAllPersons();

}
