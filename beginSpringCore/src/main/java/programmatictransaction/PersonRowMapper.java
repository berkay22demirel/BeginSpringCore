package programmatictransaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person2> {

	public Person2 mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		String surname = resultSet.getString("surname");
		int age = resultSet.getInt("age");

		Person2 person = new Person2(id, name, surname, age);

		return person;
	}

}
