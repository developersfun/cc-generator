package com.devjam.scheduler;

import com.devjam.kafka.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class StatementScheduler {

    @Autowired
    KafkaProducer kafkaProducer;

    @Value("transaction.producer.topic")
    private String transactionProducerTopic;

    @Scheduled(cron = "${transaction.scheduler.cron.expression}")
    public void reportCurrentTime() {

        kafkaProducer.sendMessage(transactionProducerTopic, message);
    }
}
