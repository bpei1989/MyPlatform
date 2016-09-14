package com.myplatform.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.myplatform.web.ws.TestCaseServiceImp;
import com.myplatform.web.entity.TestCase;

@Controller
public class DashboardController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/dashboard.htm", method = RequestMethod.GET)
	public String greetPath(ModelMap model) {
		logger.debug("Method greetPath");
		//model.addAttribute("name", name);
		TestCaseServiceImp testCase = new TestCaseServiceImp();
		TestCase list = testCase.findById(1);
		model.addAttribute("id", list.getId());
		model.addAttribute("level", list.getLevel());
		model.addAttribute("description", list.getDescripton());
		return "dashboard";
	}

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String hello() {
		logger.debug("Method hello");
		return "home";
	}
}
