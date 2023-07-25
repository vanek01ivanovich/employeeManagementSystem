package com.example.employeemanagementsystem.service.impl;

import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Employee;
import com.example.employeemanagementsystem.exception.EMSException;
import com.example.employeemanagementsystem.persistence.dao.EmployeeDao;
import com.example.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private static final int AMOUNT = 3;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDao.getEmployeeById(id)
                .orElseThrow(() -> new EMSException("User is not found with id " + id));
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        return employeeDao.deleteEmployeeById(id);
    }

    @Override
    public boolean createEmployee(EmployeeModificationDto employeeDto) {
        return employeeDao.createEmployee(employeeDto);
    }

    @Override
    public boolean updateEmployee(EmployeeModificationDto employeeDto) {
       return employeeDao.updateEmployee(employeeDto);
    }

    @Override
    public Employee getEmployeeByUserName(String username) {
        return employeeDao.getEmployeeByUserName(username)
                .orElseThrow(() -> new EMSException("User is not found with username " + username));
    }

    @Override
    public List<Employee> getAllEmployees(int page) {
        return employeeDao.getAllEmployees((page - 1) * AMOUNT, AMOUNT);
    }

    @Override
    public List<Employee> getAllEmployees(int page, String sorting, String order) {
        return employeeDao.getAllEmployees((page - 1) * AMOUNT, AMOUNT, sorting, order);
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String departmentName) {
        return employeeDao.getEmployeeByDepartment(departmentName);
    }
}
