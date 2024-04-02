package com.diegotorres.evaluaciondiegotorres.aplication.service;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.ReportInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceReportOutPort;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@RequiredArgsConstructor
@Service
public class ServiceReport implements ReportInputPort {

private final PersistenceReportOutPort persistenceReportOutPort;
    @Override
    public ReporteDto getMoves(Long clientID, Date from, Date to) {
       return persistenceReportOutPort.getMoves(clientID,from,to);
    }
}
