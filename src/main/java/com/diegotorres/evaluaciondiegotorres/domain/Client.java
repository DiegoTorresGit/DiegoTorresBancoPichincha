package com.diegotorres.evaluaciondiegotorres.domain;

import lombok.*;

import java.util.Date;

@Data
public class Client {
    private  Long id;
    private Date date;
    private Boolean state;

}
