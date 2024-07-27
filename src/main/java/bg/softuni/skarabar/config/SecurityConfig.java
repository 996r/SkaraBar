package bg.softuni.skarabar.config;

import bg.softuni.skarabar.repo.UserRepository;
import bg.softuni.skarabar.service.SkaraUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
    public class SecurityConfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests(
                            authorizeRequest -> {
                                authorizeRequest
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .requestMatchers("/","/about","/service","/contact","/booking","/team",
                                                "/testimonial","/menu","/commons", "/login","/register","/img/**","/lib/**",
                                                "/webfonts/**").permitAll()
                                        .anyRequest().authenticated();
                            }
                    )
                    .formLogin(formLogin -> {
                        formLogin.loginPage("/login");
                        formLogin.usernameParameter("email");
                        formLogin.passwordParameter("password");
                        formLogin.defaultSuccessUrl("/team",true );
                        formLogin.failureForwardUrl("/login");

                    })
                    .logout(
                            logout -> {
                                logout.logoutUrl("/logout");
                                logout.logoutSuccessUrl("/");
                                logout.invalidateHttpSession(true);
                            }
                    )
                    .build();

        }
        @Bean
        public SkaraUserDetailsService userDetailsService (UserRepository userRepository){
            return new SkaraUserDetailsService(userRepository);
        }
        @Bean
        public PasswordEncoder passwordEncoder(){
            return Pbkdf2PasswordEncoder
                    .defaultsForSpringSecurity_v5_8();
        }
}
