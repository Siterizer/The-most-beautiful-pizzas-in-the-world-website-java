package world.the.in.pizzas.beautiful.most.the.website.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String renderRegister(){
        return "register";
    }
}
