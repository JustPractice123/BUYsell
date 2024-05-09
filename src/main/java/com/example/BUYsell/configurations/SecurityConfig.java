package com.example.BUYsell.configurations;

import com.example.BUYsell.Services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    UserService userService(){return new UserService();
    }
    @Bean
    PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoder());
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/enter")
                .defaultSuccessUrl("/profile")
                .failureUrl("/login?user_error")
                .usernameParameter("email")
                .passwordParameter("password");
        http.logout()
                .logoutUrl("/to-exit")
                .logoutSuccessUrl("/login");
        http.csrf().disable();
        return http.build();
    }

}
