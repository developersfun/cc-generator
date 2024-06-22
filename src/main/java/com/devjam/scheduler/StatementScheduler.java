package com.devjam.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class StatementScheduler {

    @Scheduled(cron = "${transaction.scheduler.cron.expression}")
    public void reportCurrentTime() {

    }
}
