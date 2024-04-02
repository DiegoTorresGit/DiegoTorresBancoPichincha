package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity;

import com.diegotorres.evaluaciondiegotorres.domain.Account;
import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "BAN_TRANSACTION")
@Entity
public class TransacctionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PK_TRANSACTION_ID")
    private Long id;
    @Column(name = "DATETIME_TRA")
    private Timestamp date;
    @Column(name = "VALUE_TRA")
    private Double value;
    @Column(name = "AVAILABLE_BALANCE")
    private Double available_balance;
    @Column(name = "INITIAL_BALANCE")
    private Double initial_balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ACCOUNT_ID", nullable = false)
    private AccountEntity account;
}
