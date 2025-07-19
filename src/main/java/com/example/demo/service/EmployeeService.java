package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer id);
}
