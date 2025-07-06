package com.example.employeedemo.service;

import com.example.employeedemo.entity.Employee;
import com.example.employeedemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    public void addEmployee(Employee employee) {
        repository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

}
