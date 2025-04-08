package com.oriantal.MySpringbootApp_001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class MySpringbootApp001Controller {
	
	@Value("${spring.application.name}")
	String sprinAapplicationName;

	
	@GetMapping("/dispay")
	public String display() {
		System.out.println("Get Mapping.................!" +sprinAapplicationName);
		
		
		return "Hai  sprinAapplicationName :==========>>> ::  " +sprinAapplicationName;
	}

}
