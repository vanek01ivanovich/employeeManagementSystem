package com.example.employeemanagementsystem.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private UUID id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String departmentName;

    private String roleName;

}
