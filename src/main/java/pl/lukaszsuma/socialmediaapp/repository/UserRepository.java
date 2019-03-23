package pl.lukaszsuma.socialmediaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszsuma.socialmediaapp.model.User;

public interface UserRepository extends JpaRepository<User , Long> {
}
