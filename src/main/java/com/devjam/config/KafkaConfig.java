package com.devjam.config;

import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

public class KafkaConfig {

    @Value("kafka.bootstrap.url")
    private String kafkaUrl;

    @Bean
    public ConsumerFactory<String, String> messageConsumerFactory() {
        JsonDeserializer<String> deserializer =
                new JsonDeserializer<>(String.class, false);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    messageListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> containerFactory =
                new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(messageConsumerFactory());
        return containerFactory;
    }
}
