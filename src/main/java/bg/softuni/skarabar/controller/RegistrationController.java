package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.model.dto.UserRegistrationDTO;
import bg.softuni.skarabar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("registerDTO")
    public UserRegistrationDTO registerDTO(){
        return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
@PostMapping("/register")
    public String register(UserRegistrationDTO registerDTO) {
        userService.registerUser(registerDTO);
        return "redirect:/";
    }


    @GetMapping("/commons")
    public String commons() {
        return "fragments/commons";
    }
}
