package com.example.employeemanagementsystem.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    @Value("${get.all.employees}")
    protected String GET_ALL_EMPLOYEES;

    @Value("${get.all.employees.page}")
    protected String GET_ALL_EMPLOYEES_PAGE;

    @Value("${get.all.employees.page.sort}")
    protected String GET_ALL_EMPLOYEES_PAGE_SORT;

    @Value("${get.employee.by.id}")
    protected String GET_EMPLOYEE_BY_ID;

    @Value("${delete.employee.by.id}")
    protected String DELETE_EMPLOYEE_BY_ID;

    @Value("${insert.into.employee}")
    protected String INSERT_INTO_EMPLOYEE;

    @Value("${update.employee.by.id}")
    protected String UPDATE_EMPLOYEE_BY_ID;

    @Value("${get.employee.by.username}")
    protected String GET_EMPLOYEE_BY_USERNAME;

    @Value("${get.all.employees.by.department}")
    protected String GET_EMPLOYEE_BY_DEPARTMENT;

    @Value("${get.department.by.name}")
    protected String GET_DEPARTMENT_BY_NAME;

    @Value("${get.department.by.id}")
    protected String GET_DEPARTMENT_BY_ID;

    @Value("${insert.into.department}")
    protected String INSERT_INTO_DEPARTMENT;

}
