package bg.softuni.skarabar.model.dto;

import jakarta.validation.constraints.*;

public class UserLoginDTO {
@NotBlank
@Size(min = 3, max = 20)
    private String username;
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
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
