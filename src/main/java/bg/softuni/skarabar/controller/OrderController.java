package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.model.entity.SkaraUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/order")
    public String newOrder(@AuthenticationPrincipal UserDetails userDetails,
                           Model model){
        if (userDetails instanceof SkaraUserDetails skaraUserDetails){
            model.addAttribute("welcomeMessage",skaraUserDetails.getFullName());
        }  else {
            model.addAttribute("welcomeMessage", "Anonymous");
        }

        return "order";
    }
}
