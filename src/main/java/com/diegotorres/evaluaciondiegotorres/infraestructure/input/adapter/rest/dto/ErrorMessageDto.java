package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDto {
    private HttpStatus status;
    private String message;
}
