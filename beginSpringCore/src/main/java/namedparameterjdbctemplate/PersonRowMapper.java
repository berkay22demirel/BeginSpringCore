package namedparameterjdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<PersonModel> {

	public PersonModel mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		String surname = resultSet.getString("surname");
		int age = resultSet.getInt("age");

		PersonModel person = new PersonModel(id, name, surname, age);

		return person;
	}

}
