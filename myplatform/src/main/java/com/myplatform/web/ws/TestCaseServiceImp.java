package com.myplatform.web.ws;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myplatform.web.model.TestCase;

@Service(value="testCaseService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class TestCaseServiceImp implements TestCaseService{
	private static final Logger logger = Logger.getLogger(TestCaseServiceImp.class);
	 
	private List<TestCase> list = null;
	
	public TestCaseServiceImp() {        
	    list = new LinkedList<TestCase>();
	    list.add(new TestCase(1, "P0", "Test point 1"));
	    list.add(new TestCase(2, "P0", "Test point 2"));
	    list.add(new TestCase(3, "P1", "Test point 3"));
	    list.add(new TestCase(4, "P1", "Test point 4"));   
	}
	
	@Override
	public TestCase findById(int id) {
		TestCase testCase = null;
		boolean found = false;
		ListIterator<TestCase> listIterator = list.listIterator();
		
		for(TestCase test : list) {
			if (test.getId() == id)
			{
				found = true;
				testCase = test;
			}
		}
		if (!found) {
			testCase = null;
		}
		
		return testCase;
	}
	
	@Override
	public boolean updateTestCaseByNumber(int id, TestCase testCase) {
		logger.info("updating testcase " + id);

		TestCase old = findById(id);
		boolean result = false;
		if (old != null)
		{
			old.setId(testCase.getId());
			old.setLevel(testCase.getLevel());
			old.setDescripton(testCase.getDescripton());
			result = true;
		}
		else
		{
			logger.warn("testcase:" + id + " not found");
		}
		return result;
	}
	
	@Override
	public boolean deleteTestCase(int id) {
		logger.info("deleting testcase " + id);

		TestCase test = findById(id);
		boolean result = false;
		
		if (test != null) {
			list.remove(test);
			result = true;
		}
		else {
			logger.warn("TestCase:" + id + " not found");
		}
		return result;
	}
}
