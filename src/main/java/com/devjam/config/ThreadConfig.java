package com.devjam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {

    @Value("${max.core.pool.size}")
    private int maxPoolSize;

    @Value("${thread.core.pool.size}")
    private int corePoolSize;

    @Value("${thread.queue.capacity}")
    private int threadQueueCapacity;

    @Bean(name = "statementGenerator")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(threadQueueCapacity);
        executor.setThreadNamePrefix("statement-generator-");
        return executor;
    }
}