package com.employee;

public class EmployeeManager {
    Employee[] employees;
    int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
        } else {
            System.out.println("Employee list full.");
        }
    }

    public void searchEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == empId) {
                System.out.println("Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee ID not found.");
    }

    public void deleteEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == empId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Deleted Employee ID " + empId);
                return;
            }
        }
        System.out.println("Employee ID not found.");
    }

    public void listEmployees() {
        if (size == 0) {
            System.out.println("No employees.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}

