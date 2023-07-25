package com.example.employeemanagementsystem.data.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@Builder
public class AuthenticationResponse {

    private String token;

    private String role;

    private String username;

    private Collection<?> authorities;
}