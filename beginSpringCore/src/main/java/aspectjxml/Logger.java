package aspectjxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
	
	public void logBefore() {
		System.out.println("Log Before");
	}

	public void logAfter() {
		System.out.println("Log After");
	}

	public void logAfterReturning(JoinPoint joinPoint, String resultValue) {

		System.out.println("Log After Returning");
		System.out.println("Called by : " + joinPoint.getSignature().getName());
		System.out.println("Returned value : " + resultValue);
	}

	public void logAfterThrowing(JoinPoint joinPoint, Exception thrownException) {

		System.out.println("Log After Throwing");
		System.out
				.println("Called by  : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + thrownException);

	}

	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("Log Around");
		System.out.println("Called by : " + joinPoint.getSignature().getName());
		System.out.println("Around before is running!");

		joinPoint.proceed();

		System.out.println("Around after is running!");

	}
}
