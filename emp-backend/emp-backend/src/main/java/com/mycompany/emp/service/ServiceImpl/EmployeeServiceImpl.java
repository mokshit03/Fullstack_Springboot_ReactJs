package com.mycompany.emp.service.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mycompany.emp.dto.EmployeeDto;
import com.mycompany.emp.entity.Employee;
import com.mycompany.emp.exception.ResourceNotFoundException;
import com.mycompany.emp.mapper.EmployeeMapper;
import com.mycompany.emp.repository.EmployeeRepository;
import com.mycompany.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public ResponseEntity<String> createEmployee(EmployeeDto empDto) {
//		Employee newEmp = new Employee(empData.getId(),empData.getFirstName(), 
//				                       empData.getLastName(),empData.getEmail());
		Employee newEmp = EmployeeMapper.mapToEmployee(empDto);
		empRepo.save(newEmp);
		return new ResponseEntity<>("User created Successfully with below details" + empDto.toString(), HttpStatus.CREATED);
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeDto empData) {
		Employee emp=empRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Employee found with ID: "+id));
	    emp.setFirstName(empData.getFirstName());
	    emp.setLastName(empData.getLastName());
	    emp.setEmail(empData.getEmail());
	    
	    return empRepo.save(emp);  // if ID/PK is not passed, save() performs update operation.
	}

	@Override
	public String deleteEmployee(Long Id) {
		Employee emp=empRepo.findById(Id).orElseThrow(()-> new ResourceNotFoundException("No Employee found with ID: "+Id));	   
		empRepo.deleteById(Id);
		return "DELTED!";
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> allEmps = empRepo.findAll();
		return new ResponseEntity<>(allEmps,HttpStatus.OK);
	}

	@Override
	public Employee getEmployeeById(Long Id) {
	    Employee emp=empRepo.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found!"));
		return emp;
	}
	
	

}
