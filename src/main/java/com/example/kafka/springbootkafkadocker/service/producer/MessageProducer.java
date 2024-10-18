package com.example.kafka.springbootkafkadocker.service.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.example.kafka.springbootkafkadocker.model.KafkaConstant.KAFKA_TOPIC;
import static com.example.kafka.springbootkafkadocker.util.BotIdRetriever.extractBotId;


@Service
public class MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    private int partitionIndex = 0;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) {
        processMessage(message);
    }

    private void processMessage(String message){
        String botId = extractBotId(message);
        this.kafkaTemplate.send(KAFKA_TOPIC, message);
        /*this.kafkaTemplate.send(KAFKA_TOPIC, partitionIndex, botId, message);
        partitionIndex = (partitionIndex + 1) % 3;*/

        LocalDateTime timestamp = LocalDateTime.now();
        logger.info("\n Timestamp: {} Message sent : {}", timestamp, message);
    }
}

