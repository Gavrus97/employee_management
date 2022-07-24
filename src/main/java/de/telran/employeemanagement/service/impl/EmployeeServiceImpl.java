package de.telran.employeemanagement.service.impl;

import de.telran.employeemanagement.dto.request.EmployeeRequestDTO;
import de.telran.employeemanagement.entity.Company;
import de.telran.employeemanagement.entity.Employee;
import de.telran.employeemanagement.repository.CompanyRepository;
import de.telran.employeemanagement.repository.EmployeeRepository;
import de.telran.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public void createEmployee(EmployeeRequestDTO request) {
        if (repository.existsByName(request.getEmployeeName())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("Employee {%s} already exists", request.getEmployeeName())
            );
        }

        Employee employee = Employee
                .builder()
                .name(request.getEmployeeName())
                .languageType(request.getPreferredLanguage())
                .build();
        repository.save(employee);
    }
}
