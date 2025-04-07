package com.oriantal.MySpringbootApp_001.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oriantal.MySpringbootApp_001.repository.TransactionLogRepository;
import com.oriantal.MySpringbootApp_001.transactionmanagementexample.entity.TransactionLog;



@Service
public class SubService {

    private final TransactionLogRepository repository;

    public SubService(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiresNew() {
        TransactionLog log = new TransactionLog();
        log.setMessage("Requires New transaction log");
        repository.save(log);

        // Simulate an exception
        if (true) {
            throw new RuntimeException("Simulated exception in Requires_New");
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void propagationMandatory() {
        TransactionLog log = new TransactionLog();
        log.setMessage("Mandatory transaction log");
        repository.save(log);
    }
}