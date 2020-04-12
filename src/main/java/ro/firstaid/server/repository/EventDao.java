package ro.firstaid.server.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.firstaid.server.entity.EventStatus;
import ro.firstaid.server.entity.model.Event;

import java.util.Collection;

public interface EventDao extends JpaRepository<Event, Integer> {

    Page<Event> findAllByLocation_LatitudeBetweenAndLocation_LongitudeBetweenAndEventStatusIn(Double latitudeMin, Double latitudeMax, Double longitudeMin, Double longitudeMax, Collection<EventStatus> eventStatusNames, Pageable pageable);

}
