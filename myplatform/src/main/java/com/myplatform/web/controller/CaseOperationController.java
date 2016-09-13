package com.myplatform.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CaseOperationController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping(value = "/addcase.htm", method = RequestMethod.GET)
	public String addCase() {
		return "addcase";
	}
	
	@RequestMapping(value = "/updatecase.htm", method = RequestMethod.GET)
	public String updateCase() {
		return "no";
	}
	
	@RequestMapping(value = "/no.htm", method = RequestMethod.GET)
	public String notFinised() {
		return "no";
	}
}
