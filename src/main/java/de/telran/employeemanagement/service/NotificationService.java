package de.telran.employeemanagement.service;

import de.telran.employeemanagement.entity.Company;
import de.telran.employeemanagement.entity.Employee;

import java.util.Optional;

public interface NotificationService {

    String notifyAboutStart(Employee employee, Company company);
    String notifyAboutEnd(Employee employee, Company company, Optional<String> reason);
}
