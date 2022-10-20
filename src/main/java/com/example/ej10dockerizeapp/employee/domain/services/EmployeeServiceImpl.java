package com.example.ej10dockerizeapp.employee.domain.services;

import com.example.ej10dockerizeapp.employee.domain.Employee;
import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoIn;
import com.example.ej10dockerizeapp.employee.infraestructure.dto.EmployeeDtoOut;
import com.example.ej10dockerizeapp.employee.infraestructure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDtoOut insertEmployee(Employee employee) {
        employeeRepository.save(employee);
        return new EmployeeDtoOut(employee);
    }

    @Override
    public EmployeeDtoOut updateEmployee(String id, EmployeeDtoIn employeeDtoIn) throws EntityNotFoundException {
        Employee employee = new Employee(employeeDtoIn);

        Employee empleadoConId = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe ese empleado."));
        employee.setEmployeeId(empleadoConId.getEmployeeId());
        employeeRepository.save(employee);
        return new EmployeeDtoOut(employee);
    }

    @Override
    public void deleteEmployee(String id) throws EntityNotFoundException {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new EntityNotFoundException("Ese registro no existe.");
        }
    }

    @Override
    public List<EmployeeDtoOut> getAllTheEmployees() {
        List<EmployeeDtoOut> lista = new ArrayList<>();
        employeeRepository.findAll().forEach(p -> {
            try {
                lista.add(new EmployeeDtoOut(p));
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return lista;
    }
}