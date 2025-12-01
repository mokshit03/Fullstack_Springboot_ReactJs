package com.mycompany.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.emp.dto.EmployeeDto;
import com.mycompany.emp.entity.Employee;
import com.mycompany.emp.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto empDto)
	{
		return employeeService.createEmployee(empDto);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("{id}")
	public Employee updateEmployee(@RequestBody EmployeeDto empDto, @PathVariable Long id)
	{
		Employee emp=employeeService.updateEmployee(id, empDto);
		return emp;
	}
	
	@DeleteMapping("{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		return employeeService.deleteEmployee(id);
		
	}
}
