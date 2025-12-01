package com.mycompany.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
