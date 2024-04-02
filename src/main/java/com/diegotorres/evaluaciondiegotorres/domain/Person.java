package com.diegotorres.evaluaciondiegotorres.domain;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String password;
    private String state;
}