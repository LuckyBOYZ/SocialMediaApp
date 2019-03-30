package pl.lukaszsuma.socialmediaapp.service;

import org.springframework.stereotype.Service;
import pl.lukaszsuma.socialmediaapp.model.Post;
import pl.lukaszsuma.socialmediaapp.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
       return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }
}
