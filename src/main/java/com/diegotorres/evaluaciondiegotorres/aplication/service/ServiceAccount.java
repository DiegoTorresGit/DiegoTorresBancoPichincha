package com.diegotorres.evaluaciondiegotorres.aplication.service;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.AccountInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceAccountOutPutPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceTypeAccountOutPutPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersitenceClienteOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.TypeAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceAccount implements AccountInputPort {
    private final PersitenceClienteOutPutPort persitenceClienteOutPutPort;
    private final PersistenceTypeAccountOutPutPort persistenceTypeAccountOutPutPort;
    private final PersistenceAccountOutPutPort persistenceAccountOutPutPort;
    @Override
    public Account getAccountById(Long id) {

        return persistenceAccountOutPutPort.getAccountById(id);
    }

    @Override
    public List<Account> getAllAccount() {
        return persistenceAccountOutPutPort.getAllAccount();
    }

    @Override
    public Account updateAccount(Account account, Long idAccount) {
        return null;
    }

    @Override
    public void deleteAcount(long id) {
        try
        {
            var account = persistenceAccountOutPutPort.getAccountById(id);
            if (account==null)
            {
                throw new AccountNotFoundException("La cuenta con el ID " + id + " no se encontró");
            }


            persistenceAccountOutPutPort.deleteAccount(id);
        }catch (Exception x)
        {
            throw new AccountNotFoundException("La cuenta con el ID " + id + " no se encontró");
        }


    }

    public class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public Account createAccount(Account account, Integer type, Long idClient) {
        Client client = persitenceClienteOutPutPort.getClientById(idClient);
        TypeAccount typeAccount = persistenceTypeAccountOutPutPort.getTypeAccounById(type);
        account.setTypeAccount(typeAccount);
        account.setClient(client);
        return  persistenceAccountOutPutPort.createAccount(account);
    }
}
