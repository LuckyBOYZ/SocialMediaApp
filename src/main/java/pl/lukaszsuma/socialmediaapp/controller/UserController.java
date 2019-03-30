package pl.lukaszsuma.socialmediaapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszsuma.socialmediaapp.model.User;
import pl.lukaszsuma.socialmediaapp.service.UserService;

@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger("UserController");

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        user.setRole(User.AccountRole.USER);
        user.setType(User.AccountType.PUBLIC);
        log.info(String.valueOf(user));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Hasło zostało zakodowane");
        userService.addUser(user);
    }

    @PostMapping("/login")
    public String login() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
    }

}
