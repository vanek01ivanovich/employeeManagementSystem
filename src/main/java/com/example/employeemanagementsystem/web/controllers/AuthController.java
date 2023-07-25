package com.example.employeemanagementsystem.web.controllers;

import com.example.employeemanagementsystem.data.entity.AuthRequest;
import com.example.employeemanagementsystem.data.entity.AuthenticationResponse;
import com.example.employeemanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        log.info("authenticateUser {} ", authRequest);
        Authentication authenticate = authService.getAuthentication(authRequest);
        AuthenticationResponse authenticationResponse = authService.getAuthenticationResponse(authenticate);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
