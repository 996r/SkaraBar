package bg.softuni.skarabar.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
                        formLogin.usernameParameter("username");
                        formLogin.passwordParameter("password");
                        formLogin.defaultSuccessUrl("/home");
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
}
