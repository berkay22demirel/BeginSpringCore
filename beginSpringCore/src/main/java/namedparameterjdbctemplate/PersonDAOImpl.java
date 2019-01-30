package namedparameterjdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PersonDAOImpl implements PersonDAO {

	private static final String INSERT_SQL = "INSERT INTO person(id,name, surname, age) VALUES (:id,:name,:surname,:age)";
	private static final String SELECT_SQL = "SELECT * FROM person WHERE id = :id";
	private static final String SELECT_ALL_SQL = "SELECT * FROM person";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public int insert(PersonModel person) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("id", person.getId());
		namedParameters.addValue("name", person.getName());
		namedParameters.addValue("surname", person.getSurname());
		namedParameters.addValue("age", person.getAge());
		
		int result = namedParameterJdbcTemplate.update(INSERT_SQL, namedParameters);

		System.out.println("Person is inserted - " + person);

		return result;

	}

	public PersonModel getPersonById(int id) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("id", id);
		PersonModel person = namedParameterJdbcTemplate.queryForObject(SELECT_SQL, namedParameters, new PersonRowMapper());

		System.out.println("Person is found - " + person);

		return person;
	}

	public List<PersonModel> getAllPersons() {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		List<PersonModel> personList = namedParameterJdbcTemplate.query(SELECT_ALL_SQL, namedParameters, new PersonRowMapper());

		System.out.println("Person list : ");
		for (PersonModel person : personList) {

			System.out.println(person);
		}

		return personList;
		
	}

}
