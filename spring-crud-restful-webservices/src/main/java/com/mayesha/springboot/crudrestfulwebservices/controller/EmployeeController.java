package com.mayesha.springboot.crudrestfulwebservices.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;

import com.mayesha.springboot.crudrestfulwebservices.exception.ResourceNotFoundException;
import com.mayesha.springboot.crudrestfulwebservices.model.Employee;

import com.mayesha.springboot.crudrestfulwebservices.respository.EmployeeRepository;

import java.util.List;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping ("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll(); }

	@PostMapping("/employees")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException {
	
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
		
	} 
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId, @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));	
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employeeRepository.save(employee);
		
		return ResponseEntity.ok().body(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") long employeeId ) throws ResourceNotFoundException {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		
		employeeRepository.deleteById(employeeId);
		return ResponseEntity.ok().build();
		
		
	}
}
	
