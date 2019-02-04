package aopsecondexample;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdviceImpl implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {

		System.out.println("Before Advice : " + arg0.getName());

	}

}
