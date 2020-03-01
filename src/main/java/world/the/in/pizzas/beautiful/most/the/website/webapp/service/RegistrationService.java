package world.the.in.pizzas.beautiful.most.the.website.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;

@Service
public class RegistrationService{

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(UserEntity user) {
        user.setUsername(user.getUsername().trim());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
