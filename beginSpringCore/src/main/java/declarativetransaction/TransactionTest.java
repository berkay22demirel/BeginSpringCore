package declarativetransaction;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"declarativetransaction.xml");

		PersonService personService = context.getBean(PersonService.class);

		Person3 person1 = new Person3("test", "test", 1);
		Person3 person2 = new Person3("test2", "test2", 11);
		Person3 person3 = new Person3("test3", "test3", 22);
		Address address1 = new Address("İstanbul", "Kadıköy");
		Address address2 = new Address("İstanbul", "Beşiktaş");
		Address address3 = new Address("İstanbul",
				"ŞişliŞişliŞişliŞiŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişlişlŞişliŞişliŞişliŞişliŞŞişliŞişliŞişliŞişliŞişlŞişliŞişliŞişlŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliiŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliiŞişliŞişliŞişliŞişliŞişliŞişliişliŞişliŞişliŞişliŞişliŞişliŞişliiŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişliŞişli");
		person1.setAddress(address1);
		person2.setAddress(address2);
		person3.setAddress(address3);

		try {

			personService.insertPerson(person1);
			personService.insertPerson(person2);

		} catch (Exception e) {
			System.out.println("Rollback...");
		}

		System.out.println("Person List");
		List<Person3> personList = personService.getAllPerson();
		for (Person3 person : personList) {

			System.out.println(person);
		}

		try {

			personService.insertPerson(person3);

		} catch (Exception e) {
			System.out.println("Rollback...");
		}

		System.out.println("Person List");
		List<Person3> personList2 = personService.getAllPerson();
		for (Person3 person : personList2) {

			System.out.println(person);
		}

		((ClassPathXmlApplicationContext) context).close();

	}

}
