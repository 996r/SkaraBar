package bg.softuni.skarabar.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SkaraUserDetails extends User {

    private final String firstName;
    private final String lastName;


    public SkaraUserDetails
            (String username,
             String password,
             Collection<? extends GrantedAuthority> authorities, String fistName, String lastName) {
        super(username,
                password, authorities);
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName+ " " + lastName.toString();
    }


}
