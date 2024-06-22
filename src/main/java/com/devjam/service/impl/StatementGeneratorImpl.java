package com.devjam.service.impl;

import com.devjam.dto.TransactionList;
import com.devjam.entities.Transaction;
import com.devjam.service.StatementGenerator;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public class StatementGeneratorImpl implements StatementGenerator {

    @Override
    @Async("statementGenerator")
    public void generateStatement(TransactionList transactionList) {
        for(Transaction transaction : transactionList.getTransactionList()){
            System.out.println(transaction);
        }
    }
}
