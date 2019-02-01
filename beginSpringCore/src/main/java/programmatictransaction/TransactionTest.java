package programmatictransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
	
	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("transaction.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);

		Person2 person1 = new Person2(1, "Berkay", "Demirel", 24);
		Person2 person2 = new Person2(2, "JDBC", "TEST", 12);

		Address address1 = new Address(11, "İstanbul", "Kadıköy");
		Address address2 = new Address(11, "İstanbulİstanbulİstanbulİstanbul", "Beşiktaş");

		person1.setAddress(address1);
		person2.setAddress(address2);

		personDAO.insert(person1);

		personDAO.insert(person2);

	}

}
