package dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionTest {
	
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("dependency_injection_beans.xml");

		Person person = context.getBean("personConstructorInjection", Person.class);
		System.out.println(person);

	}

}
