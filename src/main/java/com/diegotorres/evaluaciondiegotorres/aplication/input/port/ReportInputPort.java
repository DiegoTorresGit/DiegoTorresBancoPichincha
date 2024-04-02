package com.diegotorres.evaluaciondiegotorres.aplication.input.port;

import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;

import java.sql.Date;

public interface ReportInputPort {
    ReporteDto getMoves(Long clientID, Date from , Date to);
}
