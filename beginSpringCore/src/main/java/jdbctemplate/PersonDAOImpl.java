package jdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAOImpl implements PersonDAO {

	private static final String INSERT_SQL = "INSERT INTO person(id,name, surname, age) VALUES (?,?,?,?)";
	private static final String SELECT_SQL = "SELECT * FROM person WHERE id = ?";
	private static final String SELECT_ALL_SQL = "SELECT * FROM person ";

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insert(PersonModel person) {
		
		Object[] insertParams = new Object[] { person.getId(), person.getName(), person.getSurname(), person.getAge() };
		int result = jdbcTemplate.update(INSERT_SQL, insertParams);

		System.out.println("Person is inserted - " + person);

		return result;

	}

	public PersonModel getPersonById(int id) {

		Object[] selectParams = new Object[] { id };
		PersonModel person = jdbcTemplate.queryForObject(SELECT_SQL, selectParams, new PersonRowMapper());

		System.out.println("Person is found - " + person);

		return person;
	}

	public List<PersonModel> getAllPersons() {
		
		List<PersonModel> personList = jdbcTemplate.query(SELECT_ALL_SQL, new PersonRowMapper());

		System.out.println("Person list : ");
		for (PersonModel person : personList) {

			System.out.println(person);
		}

		return personList;
		
	}

}
