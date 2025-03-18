package com.springBeanfactory_applicationContext;

public class StudentBean {
	
	//variable declaration
	private String stu_name;

	//setters and getters 
	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}


	//additional method
	public void printStudentName() {
		System.out.println("Student Name :" + stu_name);
	}

	

}
