package aopfirstexample;

import org.springframework.aop.framework.ProxyFactory;

public class AOPTest {

	public static void main(String[] args) throws Exception {

		Logger target = new Logger();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(new SimpleBeforeAdviceImpl());
		proxyFactory.setTarget(target);
		Logger proxy = (Logger) proxyFactory.getProxy();
		proxy.log();

		System.out.println("---------------------------------");

		Logger targetAfter = new Logger();
		ProxyFactory proxyFactoryAfter = new ProxyFactory();
		proxyFactoryAfter.addAdvice(new SimpleAfterReturningAdviceImpl());
		proxyFactoryAfter.setTarget(targetAfter);
		Logger proxyAfter = (Logger) proxyFactoryAfter.getProxy();
		proxyAfter.log();

		System.out.println("---------------------------------");

		Logger targetArround = new Logger();
		ProxyFactory proxyFactoryArround = new ProxyFactory();
		proxyFactoryArround.addAdvice(new SimpleAroundAdviceImpl());
		proxyFactoryArround.setTarget(targetArround);
		Logger proxyArround = (Logger) proxyFactoryArround.getProxy();
		proxyArround.log();

		System.out.println("---------------------------------");

		Validator targetThrows = new Validator();
		ProxyFactory proxyFactoryThrows = new ProxyFactory();
		proxyFactoryThrows.setTarget(targetThrows);
		proxyFactoryThrows.addAdvice(new SimpleThrowsAdviceImpl());
		Validator validator = (Validator) proxyFactoryThrows.getProxy();

		try {
			validator.validateAge(-10);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
		}

	}

}
