package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class LoginController {
@GetMapping("/login")
    public String login(){

        return "login";
    }
}

