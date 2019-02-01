package hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"hibernate_beans.xml");

		PersonDAO personService = context.getBean(PersonDAOImpl.class);

		Person person1 = new Person("test", "test", 1);
		Person person2 = new Person("test2", "test2", 11);
		Person person3 = new Person("test3", "test3", 22);
		Person person4 = new Person("test4", "test4", 33);
		personService.insert(person1);
		personService.insert(person2);
		personService.insert(person3);
		personService.insert(person4);

		person1.setName("Berkay");
		person1.setSurname("Demirel");
		person1.setAge(25);
		personService.update(person1);

		personService.delete(person3);

		List<Person> personList = personService.getAllPersons();
		for (Person person : personList) {

			System.out.println(person);
		}

		((ClassPathXmlApplicationContext) context).close();

	}

}
