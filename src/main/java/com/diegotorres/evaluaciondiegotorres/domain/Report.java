package com.diegotorres.evaluaciondiegotorres.domain;

import lombok.Data;

import java.sql.Date;
@Data
public class Report {
    private String Nombre;
    private long Cuenta;
    private String Tipo;
    private Double Saldo;
    private Date Fecha;
    private Double SaldoInicial;
    private Double Movimiento;
    private Double Disponible;
}
