package ru.netology.hibernateproj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public org.springframework.security.web.SecurityFilterChain filterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        return http.build();
    }
}