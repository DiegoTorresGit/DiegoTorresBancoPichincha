package com.diegotorres.evaluaciondiegotorres.aplication.ouput.port;

import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.exception.ControlException;

import java.sql.Date;
import java.util.Optional;

public interface PersistenceTransactionOutPutPort {
    Trasaction updateTrnsaction(Trasaction client, Long idClient);
    void deleteTrnsaction(long id);
    Trasaction createTrnsaction(Trasaction client) throws ControlException;
}
