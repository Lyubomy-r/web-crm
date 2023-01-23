package web.crm.AspectAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	@Pointcut("execution(* web.crm.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* web.crm.service.*.*(..))")
	private void forServicePackage() {}
		
	@Pointcut("execution(* web.crm.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
	String theMethod = theJoinPoint.getSignature().toShortString();
	System.out.println("=====>> in @Before: calling method: " + theMethod);	
		
	// get the arguments
			Object[] args = theJoinPoint.getArgs();
			
			// loop thru and display args
			for (Object tempArg : args) {
				System.out.println("=====>> argument: " + tempArg);
			}
	}
	
	@AfterReturning(pointcut="forAppFlow()",
			 returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("=====>> in @AfterReturning: from method: " + theMethod);
				
		// display data returned
		System.out.println("=====>> result: " + theResult);
	
	}

}
	
