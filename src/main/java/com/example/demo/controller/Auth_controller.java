//package com.example.demo.controller;
//
//
//
//import java.util.Optional;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//
//import org.springframework.web.bind.annotation.*;
//
//import com.example.demo.entity.Employee;
//
//import com.example.demo.repository.EmployeeRepository;
//import com.example.demo.responseStructure.ResponseStructure;
//import com.example.demo.service.EmployeeService;
//
//
//@RestController
//@RequestMapping("/api/auth")
//public class  Auth_controller {
//	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
//	
//	@Autowired
//	private EmployeeService employeeService;
//	
//	
//	 @PostMapping("/register")
//	    public ResponseEntity<ResponseStructure<Employee>> register(@RequestBody Employee employee) {
//	        ResponseStructure<Employee> response = new ResponseStructure<>();
//	        try {
//	            Employee saved = employeeService.saveEmployee(employee, null);
//	            response.setStatus(HttpStatus.CREATED.value());
//	            response.setMessage("Employee registered successfully");
//	            response.setData(saved);
//	            return new ResponseEntity<>(response, HttpStatus.CREATED);
//	        } catch (IllegalArgumentException e) {
//	            // This handles duplicate username/email errors thrown from service layer
//	            response.setStatus(HttpStatus.BAD_REQUEST.value());
//	            response.setMessage(e.getMessage()); // e.g. "Email already exists"
//	            response.setData(null);
//	            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	        } catch (Exception e) {
//	            // Handle unexpected errors
//	            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//	            response.setMessage("An unexpected error occurred");
//	            response.setData(null);
//	            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//	    }
//
//	@PostMapping("/signup/content-manager")
//	public ResponseEntity<String> createContentManagerUser(@RequestBody Employee employee) {
//	    Optional<Employee> existingByUsername = employeeRepository.findByUsername(employee.getUsername());
//	    if (existingByUsername.isPresent()) {
//	        return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
//	    }
//	  //  String hashedPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt());
//	  //  employee.setPassword(hashedPassword);
//	    employee.setRole("ROLE_CONTENTMANAGER");
//	    employeeRepository.save(employee);
//
//	    return new ResponseEntity<>("Content Manager registered successfully", HttpStatus.CREATED);
//	}
//	@PostMapping("/signup/blog-manager")
//	public ResponseEntity<String> createBlogManagerUser(@RequestBody Employee employee) {
//	    Optional<Employee> existingByUsername = employeeRepository.findByUsername(employee.getUsername());
//	    if (existingByUsername.isPresent()) {
//	        return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
//	    }
//	 //   String hashedPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt());
//	 //   employee.setPassword(hashedPassword);
//	    employee.setRole("ROLE_BLOGMANAGER");
//	    employeeRepository.save(employee);
//
//	    return new ResponseEntity<>("Blog Manager registered successfully", HttpStatus.CREATED);
//	}
//
//
//
//
//}
//
