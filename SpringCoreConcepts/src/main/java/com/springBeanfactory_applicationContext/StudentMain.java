package com.springBeanfactory_applicationContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentMain {

	//main class connected with Student Bean class
	@Autowired
	private static StudentBean student;
	private static StudentBean student1;
	
	@Value("${id}")
	private static int id;
	
public static void main(String[] args) throws BeansException {
		
		//System.out.println("id::" +id);
		
		// main class is connected with application-contex/SpringBeans.xml
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		
		//Bean class register with application-contex/SpringBeans.xml 
		student = (StudentBean) context.getBean("studentBean");
		student1 = (StudentBean) context.getBean("studentBean1");
		
		//main class connected with Student Bean class
		student.printStudentName();
		student1.printStudentName();
		
	}

}
