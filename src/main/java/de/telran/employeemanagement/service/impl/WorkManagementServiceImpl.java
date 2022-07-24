package de.telran.employeemanagement.service.impl;

import com.sun.xml.bind.v2.TODO;
import de.telran.employeemanagement.dto.response.NotificationResponseDTO;
import de.telran.employeemanagement.entity.Company;
import de.telran.employeemanagement.entity.Employee;
import de.telran.employeemanagement.repository.CompanyRepository;
import de.telran.employeemanagement.repository.EmployeeRepository;
import de.telran.employeemanagement.service.NotificationService;
import de.telran.employeemanagement.service.WorkManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkManagementServiceImpl implements WorkManagementService {


    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final NotificationService notificationService;

    @Override
    public NotificationResponseDTO changeWorkPlace(Long employeeId, Long companyId) {
        Company company = getCompanyById(companyId);
        Employee employee = getEmployeeById(employeeId);
        employee.setCompany(company);
        employeeRepository.save(employee);

        return NotificationResponseDTO
                .builder()
                .letter(notificationService.notifyAboutStart(employee, company))
                .build();
    }

    @Override
    public NotificationResponseDTO cancelWork(Long companyId, Long employeeId, Optional<String> reason) {
        var company = getCompanyById(companyId);
        var employee = getEmployeeById(employeeId);
        employee.setCompany(null);
        employeeRepository.save(employee);

        return NotificationResponseDTO
                .builder()
                .letter(notificationService.notifyAboutEnd(employee,company,reason))
                .build();
    }


    private Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Employee with id {%s} not found", employeeId)
                )
        );
    }

    private Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Company with id {%s} not found", companyId)
                )
        );
    }

    private void checkIfCompanyExist(Long companyId) {
        if (!companyRepository.existsById(companyId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Company with id {%s} doesn't exist", companyId)
            );
        }
    }

}
