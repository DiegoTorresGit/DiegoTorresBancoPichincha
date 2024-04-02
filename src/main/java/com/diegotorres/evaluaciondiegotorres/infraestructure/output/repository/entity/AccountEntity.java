package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "BAN_ACCOUNT")
@Entity
public class AccountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PK_ACCOUNT_ID")
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STATE")
    private String state;
    @Column(name = "INITIAL_BALANCE")
    private Double initial_balance;

    @ManyToOne
    @JoinColumn(name = "FK_CLIENT_ID", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "FK_TC_ID", nullable = false)
    private TypeAccountEntity typeAccount;

}
