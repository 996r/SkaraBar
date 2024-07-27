package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.entity.UserEntity;
import bg.softuni.skarabar.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class SkaraUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public SkaraUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
      return userRepository
                .findByEmail(email)
                .map(SkaraUserDetailsService::map)
                .orElseThrow( () -> new UsernameNotFoundException("Username with " + email +" not found"));

    }

    private static UserDetails map(UserEntity userEntity){
return User
        .withUsername(userEntity.getEmail())
        .password(userEntity.getPassword())
        .authorities(List.of())
        .disabled(false)
        .build();
    }

 }




