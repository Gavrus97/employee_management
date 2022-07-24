package de.telran.employeemanagement.controller.handler;

import de.telran.employeemanagement.dto.response.HttpErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class HttpErrorsHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<HttpErrorResponseDTO> handleHttp(ResponseStatusException ex) {
        var body = HttpErrorResponseDTO
                .builder()
                .status(ex.getStatus())
                .message(ex.getReason())
                .build();
        return ResponseEntity
                .status(body.getStatus())
                .body(body);
    }
}
