package com.example.employeemanagementsystem.data.entity;

import com.example.employeemanagementsystem.data.entity.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private UUID id;

    private ERole roleName;

}
