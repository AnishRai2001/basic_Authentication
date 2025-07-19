package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.config.CustomUserDetail;

@Service  // ✅ This is essential
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepo;

    public CustomUserDetailsService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee emp = employeeRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new CustomUserDetail(emp);
    }
}
