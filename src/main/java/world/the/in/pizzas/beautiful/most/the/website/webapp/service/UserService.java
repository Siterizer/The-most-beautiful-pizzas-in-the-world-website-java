package world.the.in.pizzas.beautiful.most.the.website.webapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;
import world.the.in.pizzas.beautiful.most.the.website.webapp.repository.UserRepository;

@Service
public class UserService implements UserDetailsService, CommonService<UserEntity, Long> {

    @Autowired
    UserRepository userRepository;

    @Override
    public CrudRepository<UserEntity, Long> getRepository() {
        return userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException("User of " + username + "doesn't exist")
        );
    }
}
