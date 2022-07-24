package de.telran.employeemanagement.controller;

import de.telran.employeemanagement.dto.response.NotificationResponseDTO;
import de.telran.employeemanagement.service.WorkManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WorkManagementController {

    private final WorkManagementService service;

    @PatchMapping("/companies/{companyId}/employees/{employeeId}")
    public NotificationResponseDTO employ(@PathVariable("companyId") Long companyId,
                                          @PathVariable("employeeId") Long employeeId) {
        return service.changeWorkPlace(employeeId, companyId);
    }

    @PutMapping("/companies/{companyId}/employees/{employeeId}")
    public NotificationResponseDTO quit(@PathVariable("companyId") Long companyId,
                                        @PathVariable("employeeId") Long employeeId,
                                        @RequestParam(name = "reason", required = false) Optional<String> reason) {
        return service.cancelWork(companyId, employeeId, reason);
    }
}
