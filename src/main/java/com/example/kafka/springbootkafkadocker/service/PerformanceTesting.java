package com.example.kafka.springbootkafkadocker.service;


import com.example.kafka.springbootkafkadocker.service.consumer.MessageConsumer;
import com.example.kafka.springbootkafkadocker.service.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class PerformanceTesting {

    @Autowired
    private MessageProducer messageProducer;
    private static final Logger logger = LoggerFactory.getLogger(PerformanceTesting.class);
    private static final int MESSAGE_COUNT = 100000;
    private static final String message = """
            {
            "eventId": "12",
            "botId": "bot1",
            "spaceId": "123",
            "userName": "webex1",
            "eventName": "John Doe",
            "email": "john.doe@example.com",
            "endpoint": "https://www.server.com/TaskBot/bot/active",
            "serviceId": "serviceId1",
            "timestamp": "2024-09-20T12:00:00Z"
            }""";

    public ResponseEntity<String> perfTest(String message){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            messageProducer.sendMessage(message);
        }

        long duration = System.currentTimeMillis() - startTime;
        String result = "Total time consumption from producer end : " + duration + " ms";
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<String> concurrentTest(String message){
        long startTime = System.currentTimeMillis();
        logger.info("\n=============Concurrently sending messages from Producer end=============\n");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5000; i++) {
            executorService.submit(() -> {
                messageProducer.sendMessage(message);
            });
        }
        executorService.shutdown();
        long duration = System.currentTimeMillis() - startTime;
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        String result = "Total time consumption from producer end : " + duration + " ms";
        return ResponseEntity.ok(result);
    }

}

