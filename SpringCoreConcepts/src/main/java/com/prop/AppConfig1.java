package com.prop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:manager.properties")
public class AppConfig1 {
	
	@Bean
	public Manager manager() {
		return new Manager();
	}
}