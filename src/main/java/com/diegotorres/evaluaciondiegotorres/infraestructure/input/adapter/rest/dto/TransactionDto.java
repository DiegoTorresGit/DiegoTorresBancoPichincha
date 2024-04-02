package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto;

import com.diegotorres.evaluaciondiegotorres.domain.Account;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class TransactionDto {
    private Long id;
    private Timestamp date;
    private Double value;
    private Double available_balance;
    private Double initial_balance;
    private Account account;

}
