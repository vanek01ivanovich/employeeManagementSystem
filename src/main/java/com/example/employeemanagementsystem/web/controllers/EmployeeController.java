package com.example.employeemanagementsystem.web.controllers;

import com.example.employeemanagementsystem.data.dto.CreateEmployeeRequestDto;
import com.example.employeemanagementsystem.data.dto.EmployeeModificationDto;
import com.example.employeemanagementsystem.data.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import com.example.employeemanagementsystem.service.facade.CreateEmployeeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CreateEmployeeFacade createEmployeeFacade;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/all/{page}")
    public ResponseEntity<List<Employee>> getAll(@PathVariable int page) {
        return new ResponseEntity<>(employeeService.getAllEmployees(page), HttpStatus.OK);
    }

    @GetMapping("/all/{page}/{sorting}")
    public ResponseEntity<List<Employee>> getAll(@PathVariable int page,
                                                 @PathVariable String sorting,
                                                 @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(employeeService.getAllEmployees(page, sorting, order), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Employee> getEmployeeByUserName(@PathVariable String username) {
        return new ResponseEntity<>(employeeService.getEmployeeByUserName(username), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentName}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable String departmentName) {
        return new ResponseEntity<>(employeeService.getEmployeeByDepartment(departmentName), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> createEmployee(@RequestBody CreateEmployeeRequestDto createEmployeeRequestDto) {
        return new ResponseEntity<>(createEmployeeFacade.createEmployee(createEmployeeRequestDto), HttpStatus.OK);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> updateEmployee(@RequestBody EmployeeModificationDto employeeModificationDto) {
        return new ResponseEntity<>(createEmployeeFacade.updateEmployee(employeeModificationDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable String id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }


}
