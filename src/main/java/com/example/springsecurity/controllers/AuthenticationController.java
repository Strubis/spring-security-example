package com.example.springsecurity.controllers;

import com.example.springsecurity.config.JwtUtils;
import com.example.springsecurity.dto.AuthenticationRequest;
import com.example.springsecurity.service.AuthenticationService;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Emerson
 * @since 2023
 * */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authentication(@RequestBody AuthenticationRequest authenticationRequest){
        authenticationService.authenticate(authenticationRequest);

        final UserDetails user = userService.loadUserByUsername(authenticationRequest.getEmail());
        if(user != null){
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }

        return ResponseEntity.status(400).body("Error has occurred!");
    }

}
