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
public class CompanyRequestDTO {

    @Size(min = 1, max = 50, message = "company name must be 1-50 chars")
    @NotBlank(message = "companyName cannot be blank")
    private String companyName;

    private LanguageType language;
}
