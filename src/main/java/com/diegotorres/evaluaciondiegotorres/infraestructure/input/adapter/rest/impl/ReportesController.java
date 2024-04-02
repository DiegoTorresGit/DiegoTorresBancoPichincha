package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl;
import com.diegotorres.evaluaciondiegotorres.aplication.input.port.ReportInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.input.port.TransactionInputPort;
import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.exception.ControlException;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportesController {
    private final ReportInputPort transactionInputPort;
    @GetMapping("/Report")
    ResponseEntity<Trasaction> GetMove(@RequestParam("idClient") Long idClient, @RequestParam("from")Date from, @RequestParam("to") Date to)
            throws ControlException {
      var x=   transactionInputPort.getMoves(idClient,from,to);
        return null;
    }
}
