package com.oriantal.MySpringbootApp_001.service;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Isolation;
import com.oriantal.MySpringbootApp_001.repository.AccountRepository;
import com.oriantal.MySpringbootApp_001.transactionmanagementexample.entity.Account;

//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + fromAccountId));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + toAccountId));

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in account: " + fromAccountId);
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Simulate a runtime exception to test transaction rollback
        if (amount > 1000) {
            throw new RuntimeException("Simulated exception: Transaction should roll back");
        }
    }
    
    
   

    // Example of READ_COMMITTED isolation level
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void readCommittedExample() {
        System.out.println("Fetching accounts...");
        accountRepository.findAll().forEach(account -> {
            System.out.println(account.getName() + " - Balance: " + account.getBalance());
        });
    }

    // Example of REPEATABLE_READ isolation level
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void repeatableReadExample() {
        System.out.println("Fetching accounts...");
        accountRepository.findAll().forEach(account -> {
            System.out.println(account.getName() + " - Balance: " + account.getBalance());
        });
    }

    // Example of SERIALIZABLE isolation level
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void serializableExample() {
        System.out.println("Fetching accounts...");
        accountRepository.findAll().forEach(account -> {
            System.out.println(account.getName() + " - Balance: " + account.getBalance());
        });
    }
    
    
}
