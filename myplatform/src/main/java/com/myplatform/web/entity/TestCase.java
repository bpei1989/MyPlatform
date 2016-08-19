package com.myplatform.web.entity;

public class TestCase {
	private int id;
	private String level;
	private String descripton;
	
	public TestCase()
	{
		super();
	}
	
	public TestCase(int id, String level, String descripton)
	{
		super();
		this.id = id;
		this.level = level;
		this.descripton = descripton;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
}
