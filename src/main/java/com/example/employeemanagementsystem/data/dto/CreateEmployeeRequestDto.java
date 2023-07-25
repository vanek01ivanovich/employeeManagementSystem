package com.example.employeemanagementsystem.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class CreateEmployeeRequestDto {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String departmentName;

    private String roleName;

}
