package world.the.in.pizzas.beautiful.most.the.website.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;
import world.the.in.pizzas.beautiful.most.the.website.webapp.service.RegistrationService;

import javax.validation.Valid;


@Controller
public class RegisterController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String renderRegister(Model model, @AuthenticationPrincipal UserEntity user){
        if(user != null){
            return "redirect:/homePage";
        }
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid UserEntity user){
        System.out.println(user.getUsername());
        registrationService.register(user);
        return "login";
    }
}
