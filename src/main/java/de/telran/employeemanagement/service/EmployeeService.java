package de.telran.employeemanagement.service;

import de.telran.employeemanagement.dto.request.EmployeeRequestDTO;

import java.util.Optional;

public interface EmployeeService {

    void createEmployee(EmployeeRequestDTO request);
}
