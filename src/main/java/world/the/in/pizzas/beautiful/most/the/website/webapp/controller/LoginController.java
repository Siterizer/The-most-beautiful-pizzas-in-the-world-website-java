package world.the.in.pizzas.beautiful.most.the.website.webapp.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String renderLogin(@AuthenticationPrincipal UserEntity user){
        if(user != null){
            return "redirect:/homePage";
        }
        return "login";
    }
}
