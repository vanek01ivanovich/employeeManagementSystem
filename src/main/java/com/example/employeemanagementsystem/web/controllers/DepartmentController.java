package com.example.employeemanagementsystem.web.controllers;

import com.example.employeemanagementsystem.data.entity.Department;
import com.example.employeemanagementsystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public void createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
    }

    @GetMapping("/name/{name}")
    public void getDepartmentByName(@PathVariable String name) {
        departmentService.getDepartmentByName(name);
    }

    @GetMapping("/id/{id}")
    public void getDepartmentById(@PathVariable String id) {
        departmentService.getDepartmentById(id);
    }

}
