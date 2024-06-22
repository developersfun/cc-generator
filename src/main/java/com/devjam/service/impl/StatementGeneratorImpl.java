package com.devjam.service.impl;

import com.devjam.dto.TransactionList;
import com.devjam.entities.Transaction;
import com.devjam.kafka.producer.KafkaProducer;
import com.devjam.service.StatementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public class StatementGeneratorImpl implements StatementGenerator {

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    @Async("statementGenerator")
    public void generateStatement(TransactionList transactionList) {
        for(Transaction transaction : transactionList.getTransactionList()){
            System.out.println(transaction);
        }
        kafkaProducer.sendMessage("notify", "Generated statement");
    }
}
