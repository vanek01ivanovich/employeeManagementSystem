package com.example.employeemanagementsystem.service.impl;

import com.example.employeemanagementsystem.data.entity.Department;
import com.example.employeemanagementsystem.exception.EMSException;
import com.example.employeemanagementsystem.persistence.dao.DepartmentDao;
import com.example.employeemanagementsystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentDao.getDepartmentByName(departmentName)
                .orElseThrow(() -> new EMSException("Department is not found with name " + departmentName));
    }

    @Override
    public Department getDepartmentById(String id) {
        return departmentDao.getDepartmentById(id)
                .orElseThrow(() -> new EMSException("Department is not found with id " + id));
    }

    @Override
    public boolean createDepartment(Department department) {
        return departmentDao.createDepartment(department);
    }
}
