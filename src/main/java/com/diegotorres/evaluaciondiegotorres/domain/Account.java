package com.diegotorres.evaluaciondiegotorres.domain;

import lombok.Data;

@Data
public class Account {
    private Long id;
    private Long number;
    private Boolean state;
    private Double initial_balance;
    private TypeAccount TypeAccount;
    private Client Client;
}
