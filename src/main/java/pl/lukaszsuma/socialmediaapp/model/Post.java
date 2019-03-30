package pl.lukaszsuma.socialmediaapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @CreationTimestamp
    private LocalDate creationDate;
    @OneToOne
    private User user;

}
