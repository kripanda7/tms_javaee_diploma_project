package by.teachmeskills.carparts.repository;

import by.teachmeskills.carparts.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "User.role")
    Optional<User> findByLogin(String login);
}
