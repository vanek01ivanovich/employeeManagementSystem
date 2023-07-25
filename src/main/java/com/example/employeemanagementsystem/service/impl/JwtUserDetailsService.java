package com.example.employeemanagementsystem.service.impl;

import com.example.employeemanagementsystem.data.entity.Employee;
import com.example.employeemanagementsystem.data.entity.JwtUser;
import com.example.employeemanagementsystem.exception.EMSException;
import com.example.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername username {}", username);
        Employee employee = employeeService.getEmployeeByUserName(username);
        return JwtUser.build(employee);
    }
}
