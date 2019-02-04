package aopfirstexample;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class SimpleThrowsAdviceImpl implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target,
			ArithmeticException ex) throws Throwable {

		System.out.println("ThrowsAdvice");
		System.out.println("Method: " + method.getName());
	}

}
