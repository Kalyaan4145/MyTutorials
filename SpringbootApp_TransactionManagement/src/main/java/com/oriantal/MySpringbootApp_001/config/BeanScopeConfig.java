package com.oriantal.MySpringbootApp_001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.oriantal.MySpringbootApp_001.beanscopeexample.MyBean;

@Configuration
public class BeanScopeConfig {
	
	@Bean
	@Scope("singleton") // Default scope
	public MyBean singletonBean() {
		return new MyBean("Singleton Scope");
	}
	
	
	@Bean
	@Scope("prototype")
	public MyBean prototypeBean() {
		return new MyBean("Prototype");
	}
	
	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // Only applicable in a web context
    public MyBean requestBean() {
        return new MyBean("Request Scope");
    }
	
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) // Only applicable in a web context
    public MyBean sessionBean() {
        return new MyBean("Session Scope");
    }
	

}
