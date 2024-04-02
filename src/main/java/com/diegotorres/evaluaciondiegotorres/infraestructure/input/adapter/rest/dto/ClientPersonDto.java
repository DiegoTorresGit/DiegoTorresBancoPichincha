package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto;

import com.diegotorres.evaluaciondiegotorres.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientPersonDto {
    private Date date;
    private Boolean state;
    private Person person;
}
