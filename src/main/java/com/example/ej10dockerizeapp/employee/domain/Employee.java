package com.example.ej10dockerizeapp.employee.domain;

import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoIn;
import org.hibernate.annotations.Parameter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(generator = "employee-generator")
    @GenericGenerator(name = "employee-generator",
            parameters = @Parameter(name = "prefijo",value = "employee"),
            strategy = "com.example.ej10dockerizeapp.MiGenerador")
    String employeeId;

    @Column
    String employeeName;
    @Column
    String employeeAddress;
    @Column
    String employeeEmail;

    public Employee(EmployeeDtoIn employeeDtoIn){
        employeeName = employeeDtoIn.getEmployeeName();
        employeeAddress = employeeDtoIn.getEmployeeAddress();
        employeeEmail = employeeDtoIn.getEmployeeEmail();
    }
}
