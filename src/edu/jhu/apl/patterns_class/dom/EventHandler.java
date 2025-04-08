package edu.jhu.apl.patterns_class.dom;

public class EventHandler extends Element{

    EventHandler successor;
    private String eventType = "";

    EventHandler(String tagName, Document document, String type) {
        super(tagName, document);
        this.setEventType(type);
    }

    @Override
    public void handleEvent(Event event) {
        if (event.getEventType().equals(this.eventType)) {
            System.out.println(this.getNodeName() + " handled event: " + event.getEventMessage());
        } else if (successor != null) {
            successor.handleEvent(event);
        }
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void addSuccessor(EventHandler handler) {
        this.successor = handler;
    }
}
