package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee>findByEmail(String email);

	Optional<Employee> findByUsername(String username); // ✅

	Optional<Employee> findByMobile(String mobile);

}
