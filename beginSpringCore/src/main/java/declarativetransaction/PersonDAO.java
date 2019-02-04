package declarativetransaction;

import java.util.List;

public interface PersonDAO {

	public void insert(Person3 person);

	public List<Person3> findAll();

}
