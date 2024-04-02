package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.TransactionInputPort;
import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.exception.ControlException;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.TransactionDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionInputPort transactionInputPort;
    private final TransactionMapper transactionMapper;

    @PostMapping("/transaction")
    ResponseEntity<Trasaction> Transaction(@RequestBody TransactionDto transactionDto, @RequestParam("idAccount") Long idAccount)
            throws ControlException {
        Trasaction trasaction = transactionInputPort.createTransaction(transactionMapper.ToEntity(transactionDto), idAccount);
        return ResponseEntity.ok(trasaction);
    }
}
