package com.example.springsecurity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emerson
 * @since 2023
 * */
@Data
@NoArgsConstructor
public class AuthenticationRequest {
    private String email, password;
}
