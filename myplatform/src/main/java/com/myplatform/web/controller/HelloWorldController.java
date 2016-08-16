package com.myplatform.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloWorldController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		logger.debug("Method hello");
		return "hello";
	}

	@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
	public String helloWorld() {
		logger.debug("Method helloWorld");
		return "hello-world";
	}
	
	@RequestMapping(value = "/hello-redirect", method = RequestMethod.GET)
	public String helloRedirect() {
		logger.debug("Method helloRedirect");
		return "redirect:/hello-world";
	}

}