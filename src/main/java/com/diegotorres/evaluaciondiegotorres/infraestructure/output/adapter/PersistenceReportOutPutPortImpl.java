package com.diegotorres.evaluaciondiegotorres.infraestructure.output.adapter;

import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceReportOutPort;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.ReportRepository;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@RequiredArgsConstructor
@Repository
@PersistenceContext
public class PersistenceReportOutPutPortImpl implements PersistenceReportOutPort {

    private final ReportRepository reportRepository;

    @Override
    public ReporteDto getMoves(Long clientID, Date from, Date to) {
        return reportRepository.ReportMove();
    }
}
