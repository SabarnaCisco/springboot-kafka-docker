package com.example.kafka.springbootkafkadocker.util;


import com.example.kafka.springbootkafkadocker.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BotIdRetriever {
    public static String extractBotId(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Event event = objectMapper.readValue(message, Event.class);
            String botId = event.getBotId();
            System.out.println("Bot ID: " + botId);
            return botId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

