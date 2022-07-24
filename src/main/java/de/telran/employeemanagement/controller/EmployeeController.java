package de.telran.employeemanagement.controller;

import de.telran.employeemanagement.dto.request.EmployeeRequestDTO;
import de.telran.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/employees")
    public void create(@RequestBody @Valid EmployeeRequestDTO requestDTO) {
        service.createEmployee(requestDTO);
    }
}
