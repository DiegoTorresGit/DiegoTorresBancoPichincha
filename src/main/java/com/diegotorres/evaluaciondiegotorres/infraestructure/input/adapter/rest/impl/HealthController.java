package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> getHealthController(){
        return ResponseEntity.ok("Server ok");
    }
}
