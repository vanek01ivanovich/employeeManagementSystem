package com.example.employeemanagementsystem.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class EmployeeModificationDto {

    private UUID id;

    private String password;

    private String firstName;

    private String username;

    private String lastName;

    private String email;

    private UUID departmentId;

    private UUID roleId;

}
