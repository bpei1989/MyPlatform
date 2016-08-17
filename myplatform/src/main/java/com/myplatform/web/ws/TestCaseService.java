package com.myplatform.web.ws;

import javax.jws.WebService;

import com.myplatform.web.model.TestCase;


@WebService
public interface TestCaseService 
{	
	public TestCase findById(int id);
	
	public boolean updateTestCaseByNumber(int id, TestCase testCase);
	
	public boolean deleteTestCase(int id);

}
