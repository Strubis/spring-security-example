package com.example.springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is used to test our security.
 *
 * @author Emerson
 * @since 2023
 * */
@RestController
@RequestMapping("/api/v1/welcome")
public class WelcomeController {

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi(){
        return ResponseEntity.ok("Hi, welcome to Spring Security!");
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("Bye, thanks for coming!");
    }

}
