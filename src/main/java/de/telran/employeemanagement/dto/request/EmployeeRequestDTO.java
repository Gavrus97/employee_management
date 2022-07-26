package de.telran.employeemanagement.dto.request;

import de.telran.employeemanagement.entity.type.LanguageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequestDTO {

    @Size(min = 1, max = 50, message = "employeeName must be 1-50 chars")
    @NotBlank(message = "employeeName cannot be blank")
    private String employeeName;

    private LanguageType preferredLanguage;
}