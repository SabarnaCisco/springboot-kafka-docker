package com.example.kafka.springbootkafkadocker.model;

public class Event {
    private String eventId;
    private String botId;

    public Event(){}

    public Event(String eventId, String botId, String spaceId, String userName, String eventName, String email, String endpoint, String serviceId, String timestamp) {
        this.eventId = eventId;
        this.botId = botId;
        this.spaceId = spaceId;
        this.userName = userName;
        this.eventName = eventName;
        this.email = email;
        this.endpoint = endpoint;
        this.serviceId = serviceId;
        this.timestamp = timestamp;
    }

    private String spaceId;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private String userName;
    private String eventName;
    private String email;
    private String endpoint;
    private String serviceId;
    private String timestamp;
}

