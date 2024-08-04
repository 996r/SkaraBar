package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser (UserRegistrationDTO userRegistration);
}
