package de.telran.employeemanagement.service.impl;

import de.telran.employeemanagement.entity.Company;
import de.telran.employeemanagement.entity.Employee;
import de.telran.employeemanagement.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final MessageSource messageSource;

    @Override
    public String notifyAboutStart(Employee employee, Company company) {
        String language = getLanguageCode(employee, company);

        String code = "message.startWork";
        Object[] args = {employee.getName(), employee.getEmployedOn()};

        return messageSource.getMessage(
                code,
                args,
                new Locale(language)
        );
    }

    @Override
    public String notifyAboutEnd(Employee employee, Company company, Optional<String> reason) {
        return reason.isPresent() ? notifyIfFired(employee, company, reason.get()) :
                notifyIfQuit(employee, company);
    }


    private String notifyIfFired(Employee employee, Company company, String reason) {
        String language = getLanguageCode(employee, company);
        String code = "message.cancelWork.fired";
        Object[] args = {reason};
        return messageSource.getMessage(
                code,
                args,
                new Locale(language)
        );
    }

    private String notifyIfQuit(Employee employee, Company company) {
        String language = getLanguageCode(employee, company);
        String code = "message.cancelWork.quit";
        return messageSource.getMessage(
                code,
                null,
                new Locale(language)
        );
    }

    private String getLanguageCode(Employee employee, Company company) {
        return
                employee.getLanguageType() == null ?
                        company.getLanguage().getLanguageExternalId() :
                        employee.getLanguageType().getLanguageExternalId();
    }
}
