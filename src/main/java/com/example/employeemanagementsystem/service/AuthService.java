package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.data.entity.AuthRequest;
import com.example.employeemanagementsystem.data.entity.AuthenticationResponse;
import org.springframework.security.core.Authentication;

public interface AuthService {

    Authentication getAuthentication(AuthRequest authRequest);

    AuthenticationResponse getAuthenticationResponse(Authentication authenticate);

}
