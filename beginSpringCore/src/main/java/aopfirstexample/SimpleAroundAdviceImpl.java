package aopfirstexample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAroundAdviceImpl implements MethodInterceptor {

	public Object invoke(MethodInvocation arg0) throws Throwable {

		System.out.println("Arround Advice Before !");
		Object retVal = arg0.proceed();
		System.out.println("Arround Advice After ! ");
		return retVal;

	}


}
