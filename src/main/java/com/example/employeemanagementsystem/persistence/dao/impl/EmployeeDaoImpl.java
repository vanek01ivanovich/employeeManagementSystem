package com.example.employeemanagementsystem.persistence.dao.impl;

import com.example.employeemanagementsystem.constants.Constants;
import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Employee;
import com.example.employeemanagementsystem.exception.EMSException;
import com.example.employeemanagementsystem.persistence.dao.EmployeeDao;
import com.example.employeemanagementsystem.persistence.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@PropertySource("classpath:/queries/mysql_queries.properties")
@RequiredArgsConstructor
public class EmployeeDaoImpl extends Constants implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        try {
            return jdbcTemplate.query(GET_ALL_EMPLOYEES, new EmployeeMapper());
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        log.info("getEmployeeById id {}", id);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID, new EmployeeMapper(), id));
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        log.info("deleteEmployeeById id {}", id);
        try {
            jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID, id);
            return true;
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public boolean createEmployee(EmployeeModificationDto employeeDto) {
        log.info("employeeDto {}", employeeDto.toString());
        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EMPLOYEE, Statement.NO_GENERATED_KEYS);
                preparedStatement.setString(1, employeeDto.getFirstName());
                preparedStatement.setString(2, employeeDto.getLastName());
                preparedStatement.setString(3, employeeDto.getUsername());
                preparedStatement.setString(4, employeeDto.getPassword());
                preparedStatement.setString(5, employeeDto.getEmail());
                preparedStatement.setString(6, employeeDto.getDepartmentId().toString());
                preparedStatement.setString(7, employeeDto.getRoleId().toString());
                return preparedStatement;
            });
            return true;
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public boolean updateEmployee(EmployeeModificationDto employeeDto) {
        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID, Statement.NO_GENERATED_KEYS);
                preparedStatement.setString(1, employeeDto.getFirstName());
                preparedStatement.setString(2, employeeDto.getLastName());
                preparedStatement.setString(3, employeeDto.getUsername());
                preparedStatement.setString(4, employeeDto.getEmail());
                preparedStatement.setString(5, employeeDto.getDepartmentId().toString());
                preparedStatement.setString(6, employeeDto.getRoleId().toString());
                preparedStatement.setString(7, employeeDto.getId().toString());
                return preparedStatement;
            });
            return true;
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public Optional<Employee> getEmployeeByUserName(String username) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_USERNAME,
                    new EmployeeMapper(),
                    username));
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }


    @Override
    public List<Employee> getAllEmployees(int start, int amount) {
        log.info("getAllEmployees start {}, amount {}", start, amount);
        try {
            return jdbcTemplate.query(GET_ALL_EMPLOYEES_PAGE, new EmployeeMapper(), amount, start);
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployees(int start, int amount, String sorting, String order) {
        log.info("getAllEmployees start {}, amount {} sorting {} order {}", start, amount, sorting, order);
        try {
            String query = String.format(GET_ALL_EMPLOYEES_PAGE_SORT, sorting, order == null ? "ASC" : order);
            return jdbcTemplate.query(query, new EmployeeMapper(), amount, start);
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String departmentName) {
        try {
            return jdbcTemplate.query(GET_EMPLOYEE_BY_DEPARTMENT, new EmployeeMapper(), departmentName);
        } catch (Exception e) {
            log.error("Error happen with message {}", e.getMessage());
            throw new EMSException("Error happen with message " + e.getMessage());
        }
    }
}
