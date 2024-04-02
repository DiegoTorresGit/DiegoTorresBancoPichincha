package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReportEntity {
    @Id
    private Long id;
    private String Nombre;
}
