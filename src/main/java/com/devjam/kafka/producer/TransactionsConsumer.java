package com.devjam.kafka.producer;

import com.devjam.dto.TransactionList;
import com.devjam.entities.Transaction;
import com.devjam.service.StatementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

@Configuration
public class TransactionsConsumer {

    @Autowired
    StatementGenerator generator;

    @KafkaListener(topics = "advice-topic", groupId = "group-1", containerFactory = "kafkaListenerContainerFactory",autoStartup = "false")
    public void listenAsObject(@Payload String payload, Acknowledgment acknowledgment) {
        List<Transaction> transactionList = (TransactionList)payload;
        generator.generateStatement(transactionList);
        acknowledgment.acknowledge();
    }
}
