package com.diegotorres.evaluaciondiegotorres.domain;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Trasaction {
    private Long id;
    private Timestamp date;
    private Double value;
    private Double available_balance;
    private Double initial_balance;
    private Account account;
}
