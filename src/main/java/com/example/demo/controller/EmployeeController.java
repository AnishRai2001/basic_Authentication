package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.responseStructure.ApiResponse;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee created successfully", created));
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updated = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee updated successfully", updated));
    }

    // Get Single Employee
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id)
                .map(emp -> ResponseEntity.ok(new ApiResponse<>(200, "Employee found", emp)))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee list retrieved", employees));
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee deleted successfully", null));
    }
}
