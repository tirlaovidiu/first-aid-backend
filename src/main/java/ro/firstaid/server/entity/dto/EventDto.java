package ro.firstaid.server.entity.dto;


import ro.firstaid.server.entity.EventCategory;
import ro.firstaid.server.entity.EventStatus;
import ro.firstaid.server.entity.Location;

public class EventDto {
    private String id;
    private long timeStamp;
    private Location location;
    private EventCategory category;
    private String title;
    private String description;
    private EventStatus status;

    public EventDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
