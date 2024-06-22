package com.devjam.kafka.consumer;

import com.devjam.dto.TransactionList;
import com.devjam.entities.Transaction;
import com.devjam.kafka.producer.KafkaProducer;
import com.devjam.service.StatementGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

@Configuration
public class TransactionsConsumer {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    StatementGenerator generator;

    @Autowired
    Gson gson;

    @KafkaListener(topics = "transaction-topic", groupId = "group-1", containerFactory = "kafkaListenerContainerFactory", autoStartup = "false")
    public void listenAsObject(@Payload String payload, Acknowledgment acknowledgment) {
        try{
            TransactionList transactionList = gson.fromJson(payload, TransactionList.class);
            ;
            generator.generateStatement(transactionList);
        }catch (Exception ex){
            kafkaProducer.sendMessage("retry", payload);
        }finally {
            acknowledgment.acknowledge();
        }
    }
}
