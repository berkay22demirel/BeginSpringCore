package expressionlanguage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExpressionLanguageAnnotationTest {
	
	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("expression_language_beans.xml");

		PersonAnnotation person = context.getBean("personAnnotation", PersonAnnotation.class);
		System.out.println(person);

	}

}
