package autowiringXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringTest {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("auto_wiring_xml_beans.xml");

		Person personByName = context.getBean("personIdByName", Person.class);
		Person personByType = context.getBean("personIdByType", Person.class);
		Person personConstructor = context.getBean("personIdConstructor",
				Person.class);
		System.out.println("ByName --------> " + personByName);
		System.out.println("ByType --------> " + personByType);
		System.out.println("Constructor ---> " + personConstructor);

	}
	

}
