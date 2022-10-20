package com.example.ej10dockerizeapp.employee.infraestructure.dto;

import com.example.ej10dockerizeapp.employee.domain.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDtoOut {

    String employeeId;
    String employeeName;
    String employeeAddress;
    String employeeEmail;

    public EmployeeDtoOut(Employee emp){
        employeeId = emp.getEmployeeId();
        employeeName = emp.getEmployeeName();
        employeeAddress = emp.getEmployeeAddress();
        employeeEmail = emp.getEmployeeEmail();
    }
}
