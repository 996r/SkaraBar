package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.User;

public interface UserService {

    void registerUser (UserRegistrationDTO userRegistration);

   // User getUserByFullName(String fullName);
}
