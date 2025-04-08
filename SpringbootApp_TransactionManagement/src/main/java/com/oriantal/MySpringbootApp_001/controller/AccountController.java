package com.oriantal.MySpringbootApp_001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oriantal.MySpringbootApp_001.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestParam Long fromAccountId,
                                @RequestParam Long toAccountId,
                                @RequestParam double amount) {
        try {
            accountService.transferMoney(fromAccountId, toAccountId, amount);
            return "Transfer successful";
        } catch (Exception e) {
            return "Transfer failed: " + e.getMessage();
        }
    }
    
    
    @GetMapping("/read-committed")
    public String readCommitted() {
        accountService.readCommittedExample();
        return "Executed READ_COMMITTED isolation level";
    }

    @GetMapping("/repeatable-read")
    public String repeatableRead() {
        accountService.repeatableReadExample();
        return "Executed REPEATABLE_READ isolation level";
    }

    @GetMapping("/serializable")
    public String serializable() {
        accountService.serializableExample();
        return "Executed SERIALIZABLE isolation level";
    }

}
