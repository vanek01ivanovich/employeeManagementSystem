package com.example.employeemanagementsystem.persistence.mappers;

import com.example.employeemanagementsystem.data.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Slf4j
public class DepartmentMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Department.builder()
                .id(UUID.fromString(resultSet.getString("id")))
                .departmentName(resultSet.getString("department_name"))
                .build();
    }
}
