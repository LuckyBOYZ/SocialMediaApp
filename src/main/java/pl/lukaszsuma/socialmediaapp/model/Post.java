package pl.lukaszsuma.socialmediaapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "posts")
public class Post {
    private String post;
    @CreationTimestamp
    private LocalDate creationDate;
    @OneToOne
    private User user;

}
