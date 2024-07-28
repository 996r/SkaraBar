package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.entity.SkaraUserDetails;
import bg.softuni.skarabar.model.entity.UserEntity;
import bg.softuni.skarabar.model.entity.UserRoleEntity;
import bg.softuni.skarabar.model.enums.UserRoleEnum;
import bg.softuni.skarabar.repo.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
return new SkaraUserDetails(
        userEntity.getEmail(),
        userEntity.getPassword(),
        userEntity.getRoles().stream().map(UserRoleEntity::getRole).map(SkaraUserDetailsService::map).toList(),
        userEntity.getFirstName(),
        userEntity.getLastName()
);
    }
    private static GrantedAuthority map(UserRoleEnum role){
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }

 }




