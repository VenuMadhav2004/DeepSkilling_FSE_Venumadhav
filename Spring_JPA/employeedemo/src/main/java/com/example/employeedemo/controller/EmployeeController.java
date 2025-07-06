package com.example.employeedemo.controller;

import com.example.employeedemo.entity.Employee;
import com.example.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return ResponseEntity.ok("Employee saved");
    }
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

}
