package com.myplatform.web.test.controller;

import junit.framework.Assert;

import com.myplatform.web.test.TestBase;

import com.myplatform.web.controller.SayHelloController;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

public class SayHelloControllerTest extends TestBase {

	@Autowired
	private SayHelloController sayHelloController;
	
	@Test
	public void helloWorld() {
		logger.debug("hello!");
	}
	
	@Test
	public void greetingTestFromContext() {
		// given
		String name = "Tom";
		ModelMap model = new ModelMap();
		
		// when
		String path = sayHelloController.greetPath(name, model);
		
		// then
		Assert.assertEquals("greetings", path);
		Assert.assertEquals(name, model.get("name"));
	}
}
