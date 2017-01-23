package com.aopdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aopdemo.strategies.AbstractStrategy;

@RestController
public class HomeController {

	@Autowired
	@Qualifier("aopstrategy")
	AbstractStrategy strategy;

	@RequestMapping("/hello/{player}")
	public String message(@PathVariable String player) {// REST Endpoint.

		String msg = player + ", Hello " + player;
		return msg;
	}

	@RequestMapping("/before/{player}")
	public String hitBefore(@PathVariable String player) {

		String msg = player + ", Hello " + player;
		strategy.beforeExecution("This is Before");
		return msg;
	}

	@RequestMapping("/after/{player}")
	public String hitAfter(@PathVariable String player) {

		String msg = player + ", Hello " + player;
		strategy.afterExecution("This is After");
		return msg;
	}

	@RequestMapping("/around/{player}")
	public String hitAround(@PathVariable String player) {

		String msg = player + ", Hello " + player;
		strategy.aroundExecution("This is Around");
		return msg;
	}

	@RequestMapping("/afterexception/{player}")
	public String hitAfterException(@PathVariable String player) {

		String msg = player + ", Hello " + player;
		strategy.afterExceptionExecution("This is After Exception");
		return msg;
	}

}
