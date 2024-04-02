package com.diegotorres.evaluaciondiegotorres.aplication.input.port;

import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.exception.ControlException;

import java.sql.Date;


public interface TransactionInputPort {
    Trasaction updateTransaction(Trasaction client, Long idClient);
    void deleteTransaction(long id);
    Trasaction createTransaction(Trasaction client, Long idAccout) throws ControlException;
}
