package ro.firstaid.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.firstaid.server.entity.model.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
