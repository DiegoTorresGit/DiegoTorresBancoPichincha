package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "BAN_CLIENT")
@Getter
@Setter
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PK_CLIENT_ID")
    private Long id;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "STATE")
    private Boolean state;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PERSON_ID", referencedColumnName = "PK_PERSON_ID")
    private PersonEntity person;
}
