package com.example.employeemanagementsystem.persistence.dao;

import com.example.employeemanagementsystem.data.entity.Department;

import java.util.Optional;

public interface DepartmentDao {

    Optional<Department> getDepartmentByName(String departmentName);

    Optional<Department> getDepartmentById(String id);

    boolean createDepartment(Department department);
}
