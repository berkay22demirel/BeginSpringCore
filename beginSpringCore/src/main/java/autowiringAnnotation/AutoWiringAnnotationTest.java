package autowiringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowiringAnnotation.Person;

public class AutoWiringAnnotationTest {

private static ApplicationContext context;
	
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("auto_wiring_annotation_beans.xml");

		Person person = context.getBean("personId", Person.class);
		System.out.println(person);

	}
	
}
