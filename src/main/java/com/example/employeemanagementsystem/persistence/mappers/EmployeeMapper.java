package com.example.employeemanagementsystem.persistence.mappers;

import com.example.employeemanagementsystem.data.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Slf4j
public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Employee.builder()
                .id(UUID.fromString(resultSet.getString("id")))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .email(resultSet.getString("email"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .departmentName(resultSet.getString("department_name"))
                .roleName(resultSet.getString("role_name"))
                .build();
    }
}
