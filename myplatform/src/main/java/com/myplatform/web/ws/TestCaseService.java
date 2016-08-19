package com.myplatform.web.ws;

import java.util.List;

import javax.jws.WebService;

import com.myplatform.web.entity.TestCase;


@WebService
public interface TestCaseService 
{	
	public TestCase findById(int id);
	
	public boolean updateTestCaseByNumber(int id, TestCase testCase);
	
	public boolean deleteTestCase(int id);
	
	public List<TestCase> getTestCaseList(int offset, int limit);

}
