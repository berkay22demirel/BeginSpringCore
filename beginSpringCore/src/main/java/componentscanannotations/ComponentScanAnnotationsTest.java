package componentscanannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanAnnotationsTest {

private static ApplicationContext context;
	
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("component_scan_annotations_beans.xml");

		Person person = context.getBean("person", Person.class);
		PersonService service = context.getBean("personService", PersonService.class);

		service.insertPerson(person);

	}
	
}
