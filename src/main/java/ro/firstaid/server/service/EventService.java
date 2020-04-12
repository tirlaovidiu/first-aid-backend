package ro.firstaid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.firstaid.server.entity.EventStatus;
import ro.firstaid.server.entity.dto.EventDto;
import ro.firstaid.server.entity.dto.EventResponse;
import ro.firstaid.server.entity.model.Event;
import ro.firstaid.server.exception.GeneralException;
import ro.firstaid.server.repository.EventDao;
import ro.firstaid.server.util.ObjectMapperUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static java.lang.Math.PI;
import static java.lang.StrictMath.cos;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EventService {
    private final EventDao eventDao;
    private static final double R_EARTH = 6378137;

    @Autowired
    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
        ;
    }

    public EventDto getEvent(int eventId) {
        Optional<Event> optionalEvent = eventDao.findById(eventId);
        if (!optionalEvent.isPresent())
            throw new GeneralException("Event not found", NOT_FOUND);
        else return eventToEventDto(optionalEvent.get());
    }

    private EventDto eventToEventDto(Event event) {
        return ObjectMapperUtils.map(event, EventDto.class);
    }

    public EventResponse getEvents(double latitude, double longitude, double distance, int page, int pageSize, Collection<EventStatus> eventStatuses) {
        Sort orders = new Sort(Sort.Direction.DESC, "timeStamp");
        double newMinLat = latitude - (distance / R_EARTH) * (180 / PI);
        double newMinLong = longitude - (distance / R_EARTH) * (180 / PI) / cos(latitude * PI / 180);
        double newMaxLat = latitude + (distance / R_EARTH) * (180 / PI);
        double newMaxLong = longitude + (distance / R_EARTH) * (180 / PI) / cos(latitude * PI / 180);
        if(eventStatuses == null){
            eventStatuses = Arrays.asList(EventStatus.values());
        }
        Page<Event> eventPage = eventDao.findAllByLocation_LatitudeBetweenAndLocation_LongitudeBetweenAndEventStatusIn(newMinLat, newMaxLat, newMinLong, newMaxLong, eventStatuses, PageRequest.of(page, pageSize, orders));
        EventResponse eventResponse = new EventResponse();
        eventResponse.setCurrentPage(eventPage.getNumber());
        eventResponse.setNumberOfPages(eventPage.getTotalPages());
        eventResponse.setEvents(ObjectMapperUtils.mapAll(eventPage.getContent(), EventDto.class));
        return eventResponse;
    }
}
