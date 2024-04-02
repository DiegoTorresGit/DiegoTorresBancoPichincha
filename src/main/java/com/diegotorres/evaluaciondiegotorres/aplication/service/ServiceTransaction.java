package com.diegotorres.evaluaciondiegotorres.aplication.service;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.TransactionInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceAccountOutPutPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceTransactionOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.exception.ControlException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@RequiredArgsConstructor
@Service
public class ServiceTransaction implements TransactionInputPort {

    private final PersistenceAccountOutPutPort persistenceAccountOutPutPort;
    private final PersistenceTransactionOutPutPort persistenceTransactionOutPutPort;


    @Override
    public Trasaction updateTransaction(Trasaction client, Long idClient) {
        return null;
    }

    @Override
    public void deleteTransaction(long id) {
        persistenceTransactionOutPutPort.deleteTrnsaction(id);
    }

    @Override
    public Trasaction createTransaction(Trasaction trasaction, Long idAccount) throws ControlException {
            Account account = persistenceAccountOutPutPort.getAccountById(idAccount);
            double sd = account.getInitial_balance();
            double vt = trasaction.getValue();
            double total = 0;

            if (vt<0)
            {
                vt=vt*-1;
            }
            if (sd >= vt) {
                vt=trasaction.getValue();
                total = sd + vt;

                //Valor de la transaccion
                trasaction.setValue(vt);
                //Saldo disponible
                trasaction.setAvailable_balance(total);
                //Saldo inicial
                trasaction.setInitial_balance(sd);

                account.setInitial_balance(total);
                persistenceAccountOutPutPort.updateAccount(account, idAccount);

                trasaction.setAccount(account);
            } else {
                throw new ControlException("Saldo no diponible");
            }
        return persistenceTransactionOutPutPort.createTrnsaction(trasaction);
    }
}
