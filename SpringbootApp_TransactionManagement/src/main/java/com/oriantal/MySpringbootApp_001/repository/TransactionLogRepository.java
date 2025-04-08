package com.oriantal.MySpringbootApp_001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oriantal.MySpringbootApp_001.transactionmanagementexample.entity.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
}
