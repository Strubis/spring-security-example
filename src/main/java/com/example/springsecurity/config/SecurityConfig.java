package com.example.springsecurity.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LogManager.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        final String METHOD_NAME = "securityFilterChain";

        try{
            LOGGER.info(METHOD_NAME + ": method started");
            http
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .httpBasic();

            return http.build();
        } catch (Exception e) {
            LOGGER.error(METHOD_NAME + ": " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
