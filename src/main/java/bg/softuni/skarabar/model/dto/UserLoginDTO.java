package bg.softuni.skarabar.model.dto;

import jakarta.validation.constraints.*;

public class UserLoginDTO {
@NotBlank
@Size(min = 3, max = 30)
    private String email;
    private String password;

    public UserLoginDTO() {
    }

    public String getEmail() {
        return email;
    }

    public UserLoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
