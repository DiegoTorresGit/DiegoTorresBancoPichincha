package com.diegotorres.evaluaciondiegotorres.aplication.ouput.port;

import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;
import java.sql.Date;

public interface PersistenceReportOutPort {

    ReporteDto getMoves(Long clientID, Date from , Date to);
}
