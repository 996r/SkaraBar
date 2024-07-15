package bg.softuni.skarabar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping("/booking")
    public String bookingController(){
        return "booking";
    }
@GetMapping("/team")
    public String team() {
        return "team";
    }
    @GetMapping("/testimonial")
    public String testimonial(){
        return "testimonial";
    }
}
