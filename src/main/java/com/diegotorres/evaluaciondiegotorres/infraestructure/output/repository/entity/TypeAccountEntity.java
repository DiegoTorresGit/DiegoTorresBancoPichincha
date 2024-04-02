package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "BAN_TYPE_ACCOUNT")
@Entity
public class TypeAccountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PK_TC_ID")
    private Integer id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "STATE")
    private Boolean state;
}
