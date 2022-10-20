package com.example.ej10dockerizeapp.employee.infraestructure.controllers;

import java.util.List;
import javax.annotation.Resource;
import com.example.ej10dockerizeapp.employee.domain.Employee;
import com.example.ej10dockerizeapp.employee.domain.services.EmployeeService;
import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoIn;
import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postgresApp")
public class ApplicationController {

    @Resource
    EmployeeService employeeService;

    @PostMapping(value = "/createEmp")
    public EmployeeDtoOut createEmployee(@RequestBody Employee emp) {
        return employeeService.insertEmployee(emp);
    }

    @GetMapping(value = "/employeeList")
    public List<EmployeeDtoOut> getEmployees() {
        return employeeService.getAllTheEmployees();
    }

    @PutMapping(value = "/updateEmp/{id}")
    public EmployeeDtoOut modifyEmployee(@PathVariable("id") String id, @RequestBody EmployeeDtoIn emp) {
        return employeeService.updateEmployee(id,emp);
    }

    @DeleteMapping(value = "/deleteEmpById/{id}")
    public void deleteTheEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
    }
}