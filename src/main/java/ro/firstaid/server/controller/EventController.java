package ro.firstaid.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.firstaid.server.entity.EventStatus;
import ro.firstaid.server.service.EventService;

import java.util.Collection;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/around")
    public ResponseEntity getEvents(@RequestParam("lat") double latitude, @RequestParam("long") double longitude, @RequestParam(value = "dist", required = false, defaultValue = "500") double distance, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "status", required = false) Collection<EventStatus> eventStatuses) {

        return ok(eventService.getEvents(latitude, longitude, distance, page, 10, eventStatuses));
    }
    @GetMapping("/{id}")
    public ResponseEntity getEventById(@PathVariable(name = "id") int eventId){
        return ok(eventService.getEvent(eventId));
    }


}
