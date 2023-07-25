package com.example.employeemanagementsystem.service.facade.impl;

import com.example.employeemanagementsystem.data.dto.CreateEmployeeRequestDto;
import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Department;
import com.example.employeemanagementsystem.data.entity.enums.ERole;
import com.example.employeemanagementsystem.service.DepartmentService;
import com.example.employeemanagementsystem.service.EmployeeService;
import com.example.employeemanagementsystem.service.facade.CreateEmployeeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateEmployeeFacadeImpl implements CreateEmployeeFacade {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean createEmployee(CreateEmployeeRequestDto employee) {
        return employeeService.createEmployee(EmployeeModificationDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .username(employee.getUsername())
                .email(employee.getEmail())
                .password(bCryptPasswordEncoder.encode(new String(Base64.getDecoder().decode(employee.getPassword()))))
                .departmentId(getDepartmentIdByDepartmentNameOrCreateNew(employee.getDepartmentName()))
                .roleId(ERole.getRoleByName(employee.getRoleName()).getID())
                .build());
    }

    @Override
    public boolean updateEmployee(EmployeeModificationDto employeeModificationDto) {
        return employeeService.updateEmployee(employeeModificationDto);
    }

    private UUID getDepartmentIdByDepartmentNameOrCreateNew(String departmentName) {
        Department department = departmentService.getDepartmentByName(departmentName);
        log.info("department {}", department.toString());
        return department.getId();
    }

}
