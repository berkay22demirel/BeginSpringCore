package jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCTest {
	
	private static ApplicationContext context;

	public static void main(String[] args) {

		PersonModel person1 = new PersonModel("Berkay", "Demirel", 24);
		PersonModel person2 = new PersonModel("JDBC", "TEST", 12);

		context = new ClassPathXmlApplicationContext("jdbc_beans.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);

		personDAO.insert(person1);
		personDAO.insert(person2);

		personDAO.getPersonById(1);

		personDAO.getAllPersons();

	}

}
