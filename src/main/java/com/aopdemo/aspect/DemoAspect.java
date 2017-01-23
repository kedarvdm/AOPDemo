package com.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

	@Pointcut("execution(* com.aopdemo.strategies.AbstractStrategy.afterExecution(*))")
	public void executeAfter() {
	}

	@Pointcut("execution(* com.aopdemo.strategies.AbstractStrategy.beforeExecution(*))")
	public void executeBefore() {
	}

	@Pointcut("execution(* com.aopdemo.strategies.AbstractStrategy.aroundExecution(*))")
	public void executeAround() {
	}

	@Pointcut("execution(* com.aopdemo.strategies.AbstractStrategy.afterExceptionExecution(*))")
	public void executeException() {
	}

	@Around("executeAround()")
	public Object executeAroundJointPoint(ProceedingJoinPoint pjp) {
		System.out.println("Around executing method");
		Object obj = null;
		try {
			System.out.println("Around before executing method");
			obj = pjp.proceed();
			System.out.println("Around after executing method");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	@After("executeAfter()")
	public void executeAfterJointPoint() {
		System.out.println("After executing method");
	}

	@Before("executeBefore()")
	public void executeBeforeJointPoint() {
		System.out.println("Before executing method");
	}

	@AfterThrowing("executeException()")
	public void executeAfterThrowingJointPoint() {
		System.out.println("After Throwing executing method");
	}
}
