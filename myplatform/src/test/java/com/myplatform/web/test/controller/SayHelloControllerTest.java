package com.myplatform.web.test.controller;

import junit.framework.Assert;

import com.myplatform.web.test.TestBase;
import com.myplatform.web.controller.SayHelloController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SayHelloControllerTest extends TestBase {

	@Mock
	private SayHelloController sayHelloController;
	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sayHelloController = new SayHelloController();
    }
    
    @After
    public void tearDown() throws Exception {

    }
	
	@Test
	public void greetingTestFromContext() {
		String name = "Tom";
		ModelMap model = new ModelMap();
		
		String path = null;
		when(sayHelloController.greetPath(name, model)).thenReturn(path);
		
		Assert.assertEquals("greetings", path);
		Assert.assertEquals(name, model.get("name"));
	}
}
