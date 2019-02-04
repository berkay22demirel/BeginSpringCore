package aspectjxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjTest {

	ApplicationContext context;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aspectj.xml");

		PersonService service = context.getBean("personServiceId",
				PersonService.class);

		service.savePerson();
		
		service.updatePerson();
		
		service.getPersonId();
		
		try {
			
			service.deletePerson();

		} catch (Exception e) {

		}
		
		service.getAllPersons();

		((ClassPathXmlApplicationContext) context).close();

	}

}
