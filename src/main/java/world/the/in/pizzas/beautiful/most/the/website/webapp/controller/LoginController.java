package world.the.in.pizzas.beautiful.most.the.website.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;
import world.the.in.pizzas.beautiful.most.the.website.webapp.service.RegistrationService;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/login")
    public String renderLogin(@AuthenticationPrincipal UserEntity user){
        if(user != null){
            return "redirect:/homePage";
        }
        return "login";
    }
}
