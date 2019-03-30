package pl.lukaszsuma.socialmediaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszsuma.socialmediaapp.model.Post;

public interface PostRepository extends JpaRepository<Post , Long> {
}
