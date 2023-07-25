package com.example.employeemanagementsystem.service.facade;

import com.example.employeemanagementsystem.data.dto.CreateEmployeeRequestDto;
import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Employee;

public interface CreateEmployeeFacade {

    boolean createEmployee(CreateEmployeeRequestDto employee);

    boolean updateEmployee(EmployeeModificationDto employeeModificationDto);

}
