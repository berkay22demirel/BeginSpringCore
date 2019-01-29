package expressionlanguage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExpressionLanguageTest {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("expression_language_beans.xml");

		Person person = context.getBean("personXML", Person.class);
		System.out.println(person);

	}
	
}
