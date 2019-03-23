package pl.lukaszsuma.socialmediaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.lukaszsuma.socialmediaapp.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;
}
