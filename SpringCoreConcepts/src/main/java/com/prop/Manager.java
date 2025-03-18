package com.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Manager implements Employee{
	
	@Value("${id}")
	private int id;
	@Value("${email}")
	private String email;

	public void work() {
		System.out.println("Manage the branch office");

	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
}
