package com.example.employeemanagementsystem.persistence.dao.impl;

import com.example.employeemanagementsystem.constants.Constants;
import com.example.employeemanagementsystem.data.entity.Department;
import com.example.employeemanagementsystem.persistence.dao.DepartmentDao;
import com.example.employeemanagementsystem.persistence.mappers.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DepartmentDaoImpl extends Constants implements DepartmentDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Department> getDepartmentByName(String departmentName) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(GET_DEPARTMENT_BY_NAME, new DepartmentMapper(), departmentName));
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Department> getDepartmentById(String id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(GET_DEPARTMENT_BY_ID, new DepartmentMapper(), id));
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public boolean createDepartment(Department department) {
        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_DEPARTMENT, Statement.NO_GENERATED_KEYS);
                preparedStatement.setString(1, department.getDepartmentName());
                return preparedStatement;
            });
            return true;
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            return false;
        }
    }
}
