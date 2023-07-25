package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    boolean deleteEmployeeById(String id);

    boolean createEmployee(EmployeeModificationDto employeeDto);

    boolean updateEmployee(EmployeeModificationDto employeeDto);

    Employee getEmployeeByUserName(String username);

    List<Employee> getAllEmployees(int page);

    List<Employee> getAllEmployees(int page, String sorting, String order);

    List<Employee> getEmployeeByDepartment(String departmentName);
}
