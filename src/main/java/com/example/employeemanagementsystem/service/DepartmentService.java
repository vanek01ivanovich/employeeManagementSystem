package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.data.entity.Department;

public interface DepartmentService {
    Department getDepartmentByName(String departmentName);

    Department getDepartmentById(String id);

    boolean createDepartment(Department department);
}
