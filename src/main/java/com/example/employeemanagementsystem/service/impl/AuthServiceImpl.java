package com.example.employeemanagementsystem.service.impl;

import com.example.employeemanagementsystem.configs.token.JwtTokenProvider;
import com.example.employeemanagementsystem.data.entity.AuthRequest;
import com.example.employeemanagementsystem.data.entity.AuthenticationResponse;
import com.example.employeemanagementsystem.data.entity.JwtUser;
import com.example.employeemanagementsystem.exception.EMSException;
import com.example.employeemanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Authentication getAuthentication(AuthRequest authRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                            new String(Base64.getDecoder().decode(authRequest.getPassword()))));
        } catch (Exception exception) {
            throw new EMSException("Authentication failed with message " + exception.getMessage());
        }

        if (authentication == null) {
            throw new EMSException("Authentication failed - authentication is null");
        }
        return authentication;
    }

    @Override
    public AuthenticationResponse getAuthenticationResponse(Authentication authenticate) {
        JwtUser user = (JwtUser) authenticate.getPrincipal();
        String role = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse(null);
        String token = jwtTokenProvider.generateAccessToken(user);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(token)
                .role(role)
                .username(user.getUsername())
                .authorities(authenticate.getAuthorities())
                .build();
        log.info(authenticationResponse.toString());
        return authenticationResponse;
    }
}
