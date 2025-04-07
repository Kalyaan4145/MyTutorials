package com.oriantal.MySpringbootApp_001.service;

import org.springframework.stereotype.Service;

import com.oriantal.MySpringbootApp_001.repository.TransactionLogRepository;
import com.oriantal.MySpringbootApp_001.transactionmanagementexample.entity.TransactionLog;

import jakarta.transaction.Transactional;


@Service
public class MainService {

    private final TransactionLogRepository repository;
    private final SubService subService;

    public MainService(TransactionLogRepository repository, SubService subService) {
        this.repository = repository;
        this.subService = subService;
    }

    @Transactional
    public void mainTransaction() {
        TransactionLog log = new TransactionLog();
        log.setMessage("Main transaction log");
        repository.save(log);

        try {
            subService.propagationRequiresNew();
        } catch (Exception e) {
            System.out.println("Handled exception from Requires_New");
        }

        subService.propagationMandatory();
    }
}