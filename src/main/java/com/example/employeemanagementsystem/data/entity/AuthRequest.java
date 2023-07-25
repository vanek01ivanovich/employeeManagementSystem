package com.example.employeemanagementsystem.data.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthRequest {

    private String username;

    private String password;

}
