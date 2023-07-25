package com.example.employeemanagementsystem.data.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JwtUser implements UserDetails {

    private UUID id;

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String departmentName;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static JwtUser build(Employee user) {
        return JwtUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .username(user.getUsername())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .departmentName(user.getDepartmentName())
                .authorities(Stream.of(new SimpleGrantedAuthority(user.getRoleName())).collect(Collectors.toList()))
                .build();
    }

}
