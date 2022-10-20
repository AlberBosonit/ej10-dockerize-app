package com.example.ej10dockerizeapp.employee.infraestructure.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDtoIn {
    String employeeName;
    String employeeAddress;
    String employeeEmail;
}
