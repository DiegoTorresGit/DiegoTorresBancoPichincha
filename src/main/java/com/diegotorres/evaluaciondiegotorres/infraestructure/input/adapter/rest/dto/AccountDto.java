package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto;

import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.TypeAccount;
import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private Long number;
    private Boolean state;
    private Double initial_balance;
    private TypeAccount TypeAccount;
    private Client Client;
}
