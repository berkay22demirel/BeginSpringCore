package dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("dependency_injection_beans.xml");

		SetterInjection setterInjection1 = context.getBean("person1Id",SetterInjection.class);
		SetterInjection setterInjection2 = context.getBean("person2Id",SetterInjection.class);
		System.out.println(setterInjection1);
		System.out.println(setterInjection2);

	}

}
