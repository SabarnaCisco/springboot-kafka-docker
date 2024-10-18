package com.example.kafka.springbootkafkadocker.service.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.example.kafka.springbootkafkadocker.model.KafkaConstant.KAFKA_TOPIC;


@Service
public class MessageConsumer {


    private final List<String> consumedMessages = new ArrayList<>();
    private LocalDateTime localDateTime;
    private LocalDateTime startTime;
    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    /*@KafkaListener(
            topicPartitions = @TopicPartition(topic = "test-topic", partitions = "0")
            , groupId = "performance-group")
    public void listenPartition0(String message) {
        processMessage(message);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "test-topic", partitions = "1")
            , groupId = "performance-group")
    public void listenPartition1(String message) {
        processMessage(message);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "test-topic", partitions = "2")
            , groupId = "performance-group")
    public void listenPartition2(String message) {
        processMessage(message);
    }*/

    private void processMessage(String message) {
        if (localDateTime == null) {
            startTime = LocalDateTime.now();
        }
        consumedMessages.add(message);
        localDateTime = LocalDateTime.now();
        logger.info("\n Timestamp: {} Consumer received message: {}", localDateTime, message);
    }

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "performance-group")
    public void listenGroup(String message) {
        processMessage(message);
    }



   /* @KafkaListener(topics = KAFKA_TOPIC, groupId = "performance-group")
    public void listenGroup2(String message) {
        if (localDateTime == null) {
            startTime = LocalDateTime.now();
        }
        consumedMessages.add(message);
        localDateTime = LocalDateTime.now();
        logger.info("\n Timestamp: {} Consumer 2 received message: {}", localDateTime, message);
    }

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "performance-group")
    public void listenGroup3(String message) {
        if (localDateTime == null) {
            startTime = LocalDateTime.now();
        }
        consumedMessages.add(message);
        localDateTime = LocalDateTime.now();
        logger.info("\n Timestamp: {} Consumer 3 received message: {}", localDateTime, message);
    }*/

    public List<String> getConsumedMessages(){
        return consumedMessages;
    }

    public ResponseEntity<String> getMessageCount(){
        return ResponseEntity.ok("Message-count : " + consumedMessages.size());
    }

    public ResponseEntity<String> getTotalConsumptionTime(){
        Duration duration = Duration.between(startTime, localDateTime);
        return ResponseEntity.ok("Total time consumption from consumers end : " + duration.toMillis() + " ms");
    }
}


