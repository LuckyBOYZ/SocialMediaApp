package pl.lukaszsuma.socialmediaapp.controller;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.web.bind.annotation.*;
import pl.lukaszsuma.socialmediaapp.model.Post;
import pl.lukaszsuma.socialmediaapp.model.User;
import pl.lukaszsuma.socialmediaapp.service.PostService;
import pl.lukaszsuma.socialmediaapp.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class PostController {

    private PostService postService;

    private UserService userService;

    public PostController(PostService postService , UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping
    public void savePost(@RequestBody Post post, Principal principal){
        User user = userService.getByUsername(principal.getName());
        post.setUser(user);
        postService.savePost(post);

    }
}
