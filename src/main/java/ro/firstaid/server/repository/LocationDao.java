package ro.firstaid.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.firstaid.server.entity.Location;


public interface LocationDao extends JpaRepository<Location, Integer> {

}
