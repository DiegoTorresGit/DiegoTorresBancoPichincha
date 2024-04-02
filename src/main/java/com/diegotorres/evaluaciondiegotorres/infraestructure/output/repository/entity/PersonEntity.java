package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "BAN_PERSON")
@Entity
public class PersonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PK_PERSON_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRES")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATE")
    private String state;
}
