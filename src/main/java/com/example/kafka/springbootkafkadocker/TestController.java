/*
package com.example.kafka.springbootkafkadocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final com.example.kafka.springbootkafkadocker.Producer producer;

    @Autowired
    public TestController(com.example.kafka.springbootkafkadocker.Producer producer) {
        this.producer = producer;
    }
    @PostMapping("/publish/{message}")
    public void messageToTopic(@PathVariable String message){

        this.producer.sendMessage(message);


    }
}
*/
