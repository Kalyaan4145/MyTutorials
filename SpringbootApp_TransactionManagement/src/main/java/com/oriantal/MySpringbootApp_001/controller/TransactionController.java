package com.oriantal.MySpringbootApp_001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oriantal.MySpringbootApp_001.service.MainService;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final MainService mainService;

    public TransactionController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/test")
    public String testTransactions() {
        try {
            mainService.mainTransaction();
            return "Transactions executed successfully";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}