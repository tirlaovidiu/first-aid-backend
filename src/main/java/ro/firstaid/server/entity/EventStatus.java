package ro.firstaid.server.entity;


import java.io.Serializable;

public enum EventStatus implements Serializable {

    DRAFT(0),
    IN_PROGRESS(1),
    COMPLETED(2),
    DELETED(3);

    private int value;

    EventStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EventStatus parse(int id) {
        EventStatus status = null; // Default
        for (EventStatus item : EventStatus.values()) {
            if (item.getValue() == id) {
                status = item;
                break;
            }
        }
        return status;
    }
}
