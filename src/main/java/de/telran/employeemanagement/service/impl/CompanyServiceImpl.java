package de.telran.employeemanagement.service.impl;

import de.telran.employeemanagement.dto.request.CompanyRequestDTO;
import de.telran.employeemanagement.entity.Company;
import de.telran.employeemanagement.repository.CompanyRepository;
import de.telran.employeemanagement.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public void addCompany(CompanyRequestDTO request) {
        if (repository.existsByName(request.getCompanyName())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("Company with name {%s} already exists", request.getCompanyName())
            );
        }

        Company company = Company
                .builder()
                .name(request.getCompanyName())
                .language(request.getLanguage())
                .build();

        repository.save(company);
    }
}
