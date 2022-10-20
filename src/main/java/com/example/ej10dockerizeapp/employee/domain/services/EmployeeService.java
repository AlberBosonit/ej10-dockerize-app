package com.example.ej10dockerizeapp.employee.domain.services;

import java.util.List;
import com.example.ej10dockerizeapp.employee.domain.Employee;
import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoIn;
import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoOut;

import javax.persistence.EntityNotFoundException;

public interface EmployeeService {

    EmployeeDtoOut insertEmployee(Employee emp);
    EmployeeDtoOut updateEmployee(String id, EmployeeDtoIn emp);
    List<EmployeeDtoOut> getAllTheEmployees();
    void deleteEmployee(String id);
}
