package pl.lukaszsuma.socialmediaapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.lukaszsuma.socialmediaapp.model.User;
import pl.lukaszsuma.socialmediaapp.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger("UserService");

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        log.info(String.valueOf(user));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login: " + username + " does not exist"));
    }

    public User getByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login: " + username + " does not exist"));
    }
}
