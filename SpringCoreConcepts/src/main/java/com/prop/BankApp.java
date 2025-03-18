package com.prop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.InjectingCollections.AppConfig;
public class BankApp {

	@Autowired Manager employee;
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Manager employee = context.getBean(Manager.class);
		employee.work();
		System.out.println("Email: " + employee.getEmail());
		System.out.println("Id: " + employee.getId());
		context.close();
	}
}
