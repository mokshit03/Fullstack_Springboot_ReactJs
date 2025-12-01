package com.mycompany.emp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mycompany.emp.dto.EmployeeDto;
import com.mycompany.emp.entity.Employee;

@Service
public interface EmployeeService {

	public ResponseEntity<String> createEmployee(EmployeeDto empData);
	public Employee updateEmployee(Long id, EmployeeDto empData);
	public String deleteEmployee(Long Id);
	public ResponseEntity<List<Employee>> getAllEmployee();
	public Employee getEmployeeById(Long Id);
}
