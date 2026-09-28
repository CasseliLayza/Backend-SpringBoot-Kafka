package com.backend.spring.provider.Spring_Consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {


    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "quickstart-events", groupId = "group_id")
    public void listener(String message) {
        logger.info("Received message: {}", message);
    }

}
