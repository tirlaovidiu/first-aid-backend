package ro.firstaid.server.entity.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ro.firstaid.server.entity.EventCategory;
import ro.firstaid.server.entity.EventStatus;
import ro.firstaid.server.entity.Location;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Calendar;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private long timeStamp = Calendar.getInstance().getTimeInMillis();

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @ManyToOne
    private EventCategory eventCategory;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private EventStatus eventStatus;


}
