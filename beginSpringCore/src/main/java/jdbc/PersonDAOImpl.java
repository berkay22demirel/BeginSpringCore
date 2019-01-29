package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PersonDAOImpl implements PersonDAO {

	private static final String INSERT_SQL = "INSERT INTO person(name, surname, age) VALUES (?,?,?)";
	private static final String SELECT_SQL = "SELECT * FROM person WHERE id = ?";
	private static final String SELECT_ALL_SQL = "SELECT * FROM person ";

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int insert(PersonModel person) {
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getSurname());
			preparedStatement.setInt(3, person.getAge());
			int result = preparedStatement.executeUpdate();
			preparedStatement.close();

			System.out.println("Person is inserted - " + person);

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;

	}

	public PersonModel getPersonById(int id) {

		PersonModel person = null;
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int age = resultSet.getInt("age");
				person = new PersonModel(id, name, surname, age);

				System.out.println("Person is found - " + person);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public List<PersonModel> getAllPersons() {
		
		List<PersonModel> personList = new ArrayList<PersonModel>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int age = resultSet.getInt("age");
				PersonModel person = new PersonModel(id, name, surname, age);
				personList.add(person);
			}

			System.out.println("Person list - ");
			for (PersonModel person : personList) {
				System.out.println(person);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personList;
		
	}

}
