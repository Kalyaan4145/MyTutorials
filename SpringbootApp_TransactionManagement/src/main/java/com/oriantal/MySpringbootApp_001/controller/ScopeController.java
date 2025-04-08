package com.oriantal.MySpringbootApp_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oriantal.MySpringbootApp_001.beanscopeexample.MyBean;

@RestController
@RequestMapping("/scope")
public class ScopeController {
	
	@Autowired
    private MyBean singletonBean;

    @Autowired
    private MyBean prototypeBean;

    @Autowired
    private MyBean requestBean;

    @Autowired
    private MyBean sessionBean;
    
    @GetMapping("/test")
    public String testScopes() {
        return String.format(
            " Singleton: %s , Prototype: %s, Request: %s, Session: %s",
            System.identityHashCode(singletonBean),
            System.identityHashCode(prototypeBean),
            System.identityHashCode(requestBean),
            System.identityHashCode(sessionBean)
        );
    }

}
