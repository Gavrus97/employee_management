package de.telran.employeemanagement.service;

import de.telran.employeemanagement.dto.response.NotificationResponseDTO;

import java.util.Optional;

public interface WorkManagementService {
    NotificationResponseDTO changeWorkPlace(Long employeeId, Long companyId);
    NotificationResponseDTO cancelWork(Long companyId, Long employeeId, Optional<String> reason);
}
