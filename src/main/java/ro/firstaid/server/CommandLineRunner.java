package ro.firstaid.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.firstaid.server.entity.dto.EventResponse;
import ro.firstaid.server.repository.EventDao;
import ro.firstaid.server.repository.LocationDao;
import ro.firstaid.server.service.EventService;

/*
 ******************************
 # Created by Tirla Ovidiu #
 # 07.06.2018 #
 ******************************
*/
@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final EventService eventService;
    private final LocationDao locationDao;
    private final EventDao eventDao;

    @Autowired
    public CommandLineRunner(EventService eventService, LocationDao locationDao, EventDao eventDao) {
        this.eventService = eventService;
        this.locationDao = locationDao;
        this.eventDao = eventDao;
    }

    @Transactional
    @Override
    public void run(String... args) {
        /*Location location = new Location();
        location.setLatitude(1.0);
        location.setLongitude(1.0);

        Event event = new Event();
        event.setDescription("Desc");
        event.setLocation(locationDao.save(location));
        event.setTitle("Title");
        eventDao.save(event);

        Optional<Event> event = eventDao.findById(2);
        Event event1 = event.get();
        event1.setEventStatus(EventStatus.COMPLETED);
        eventDao.save(event1);
      */
        EventResponse events = eventService.getEvents(46.769493, 23.6007337, 1400, 0, 10, null);
        System.out.println(events.getCurrentPage());

    }
}
