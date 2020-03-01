package world.the.in.pizzas.beautiful.most.the.website.webapp.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;


@Controller
public class RegisterController {

    @GetMapping("/register")
    public String renderRegister(Model model, @AuthenticationPrincipal UserEntity user){
        if(user != null){
            return "redirect:/index";
        }
        model.addAttribute("user", new UserEntity());
        return "register";
    }
}
