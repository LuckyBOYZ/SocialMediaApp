package pl.lukaszsuma.socialmediaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszsuma.socialmediaapp.model.User;
import pl.lukaszsuma.socialmediaapp.service.UserService;

@Controller("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void addUser(User user){
        userService.addUser(user);

    }
}
