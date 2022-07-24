package de.telran.employeemanagement.controller;

import de.telran.employeemanagement.dto.request.CompanyRequestDTO;
import de.telran.employeemanagement.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @PostMapping("/companies")
    public void create(@RequestBody @Valid CompanyRequestDTO request){
        service.addCompany(request);
    }
}
