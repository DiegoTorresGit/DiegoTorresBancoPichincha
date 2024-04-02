package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto;

import lombok.*;

import java.util.Date;

@Data
public class ClientDto {
    private  Long id;
    private Date date;
    private Boolean state;
}
