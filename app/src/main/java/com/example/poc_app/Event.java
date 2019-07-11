package com.example.poc_app;

public class Event {
    private int id;
    private String eventName;
    private String eventDate;

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Event(int id, String eventName, String eventDate) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;

    }
}
