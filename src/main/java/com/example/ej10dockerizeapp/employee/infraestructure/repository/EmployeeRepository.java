package com.example.ej10dockerizeapp.employee.infraestructure.repository;

import com.example.ej10dockerizeapp.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> { }
