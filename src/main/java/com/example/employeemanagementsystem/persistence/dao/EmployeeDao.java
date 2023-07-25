package com.example.employeemanagementsystem.persistence.dao;

import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(String id);

    boolean deleteEmployeeById(String id);

    boolean createEmployee(EmployeeModificationDto employeeDto);

    boolean updateEmployee(EmployeeModificationDto employeeDto);

    Optional<Employee> getEmployeeByUserName(String username);

    List<Employee> getAllEmployees(int start, int amount);

    List<Employee> getAllEmployees(int start, int amount, String sorting, String order);

    List<Employee> getEmployeeByDepartment(String departmentName);
}
