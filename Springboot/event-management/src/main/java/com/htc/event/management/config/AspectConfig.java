package com.htc.event.management.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig 
{
	private Logger log = LoggerFactory.getLogger(AspectConfig.class);
	
	@Before(value = "execution(* com.htc.event.management.service.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint)
	{
		log.info("Calling Method: " + joinPoint.getSignature().getName());
		log.info("Params: "+Arrays.toString(joinPoint.getArgs()));
	}
	
	@After(value = "execution(* com.htc.event.management.service.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint)
	{
		log.info("Called Method: " + joinPoint.getSignature().getName());
		log.info("Params: "+Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(value = "execution(* com.htc.event.management.service.*.*(..))", returning="retVal")
	public void logStatementAfterReturing(JoinPoint joinPoint,Object retVal)
	{
		log.info("After Returning {} "+ retVal.toString() );
	}
	
	@Around(value = "execution(* com.htc.event.management.service.*.*(..))")
	public Object timeTraker(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		Long timeTaken = System.currentTimeMillis()-startTime;
		log.info("Time taken by {} is {}",joinPoint,timeTaken);
		return obj;
	}
}
