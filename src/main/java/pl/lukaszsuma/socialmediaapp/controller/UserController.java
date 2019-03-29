package pl.lukaszsuma.socialmediaapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.lukaszsuma.socialmediaapp.model.User;
import pl.lukaszsuma.socialmediaapp.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger("UserController");

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService , PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        log.info(String.valueOf(user));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Hasło zostało zakodowane");
        userService.addUser(user);
    }
}
