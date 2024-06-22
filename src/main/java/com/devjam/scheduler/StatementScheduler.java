package com.devjam.scheduler;

import com.devjam.entities.Transaction;
import com.devjam.kafka.producer.KafkaProducer;
import com.devjam.repo.TransactionRepo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class StatementScheduler {

    private final KafkaProducer kafkaProducer;

    private final TransactionRepo tnxRepo;

    private Gson gs = new Gson();

    @Value("transaction.producer.topic")
    private String transactionProducerTopic;

    @Scheduled(cron = "${transaction.scheduler.cron.expression}")
    public void getTransactionsByUserId() throws SQLException {

            List<Transaction> transactionList = tnxRepo.getAllTransactionRecords(
                    "1"
            );
            kafkaProducer.sendMessage(transactionProducerTopic, gs.toString());

    }
}

