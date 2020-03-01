package world.the.in.pizzas.beautiful.most.the.website.webapp.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import world.the.in.pizzas.beautiful.most.the.website.webapp.entity.UserEntity;

@Controller
public class HomePageController {

    @RequestMapping("/homePage")
    public String renderHomePage(Model model, @AuthenticationPrincipal UserEntity user){
        model.addAttribute("username", user.getUsername());
        return "homePage";
    }
}
