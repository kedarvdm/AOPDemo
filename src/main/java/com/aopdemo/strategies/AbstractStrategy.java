package com.aopdemo.strategies;

public abstract class AbstractStrategy {

	public abstract void aroundExecution(String request);

	public abstract void beforeExecution(String request);

	public abstract void afterExecution(String request);

	public abstract void afterExceptionExecution(String request);
}
