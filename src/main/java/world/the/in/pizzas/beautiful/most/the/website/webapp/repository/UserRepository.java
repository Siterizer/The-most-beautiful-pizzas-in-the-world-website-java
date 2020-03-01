package world.the.in.pizzas.beautiful.most.the.website.webapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;

import java.util.Optional;

@Controller
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
