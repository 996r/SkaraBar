package bg.softuni.skarabar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddMenuController {
    @GetMapping("/admin")
    public String addMenu(){


        return "admin";
    }
}
