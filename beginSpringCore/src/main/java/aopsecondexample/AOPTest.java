package aopsecondexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

		Logger beforeAdvice = context.getBean("beforeAdvice", Logger.class);
		beforeAdvice.log();
		Logger afterReturningAdvice = context.getBean("afterReturningAdvice", Logger.class);
		afterReturningAdvice.log();
		Logger aroundAdvice = context.getBean("aroundAdvice", Logger.class);
		aroundAdvice.log();
		Validator throwsAdvice = context.getBean("throwsAdvice", Validator.class);
		try {
			throwsAdvice.validateAge(-10);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
		}

		context.close();

	}

}
