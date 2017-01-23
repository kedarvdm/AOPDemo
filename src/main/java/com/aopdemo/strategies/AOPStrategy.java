package com.aopdemo.strategies;

import org.springframework.stereotype.Component;

@Component("aopstrategy")
public class AOPStrategy extends AbstractStrategy {

	public void aroundExecution(String request) {
		System.out.println(request);
	}

	public void beforeExecution(String request) {
		System.out.println(request);
	}

	public void afterExecution(String request) {
		System.out.println(request);
	}

	public void afterExceptionExecution(String request) {
		System.out.println(request);
		String s = null;
		s.toString();
	}
}
