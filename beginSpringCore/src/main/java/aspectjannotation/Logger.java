package aspectjannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class Logger {
	
	@Before("execution(* aspectjannotation.PersonService.savePerson(..))")
	public void logBefore() {
		System.out.println("Save Logger Before");
	}

	@After("execution(* aspectjannotation.PersonService.updatePerson(..))")
	public void logAfter() {
		System.out.println("Update Logger After");
	}

	@AfterReturning(pointcut = "execution(* aspectjannotation.PersonService.getPersonId(..))", returning = "resultValue")
	public void logAfterReturning(JoinPoint joinPoint, String resultValue) {

		System.out.println("GetPersonId Logger After Returning");
		System.out.println("Called by : " + joinPoint.getSignature().getName());
		System.out.println("Returned value : " + resultValue);
	}

	@AfterThrowing(pointcut = "execution(* aspectjannotation.PersonService.deletePerson(..))", throwing = "thrownException")
	public void logAfterThrowing(JoinPoint joinPoint, Exception thrownException) {

		System.out.println("DeletePerson Logger After Throwing");
		System.out
				.println("Called by  : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + thrownException);

	}

	@Around("execution(* aspectjannotation.PersonService.getAllPersons(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("GetAllPersons Logger Around");
		System.out.println("Called by : " + joinPoint.getSignature().getName());
		System.out.println("Around before is running!");

		joinPoint.proceed();

		System.out.println("Around after is running!");

	}
}
