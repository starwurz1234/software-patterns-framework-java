package edu.jhu.apl.patterns_class.dom;

public class Event {

    private final String eventMessage;
    private final String eventType;

    public Event(String type, String message) {
        this.eventType = type;
        this.eventMessage = message;
    }

    public String getEventType() {
        return this.eventType;
    }

    public String getEventMessage() {
        return this.eventMessage;
    }
}
