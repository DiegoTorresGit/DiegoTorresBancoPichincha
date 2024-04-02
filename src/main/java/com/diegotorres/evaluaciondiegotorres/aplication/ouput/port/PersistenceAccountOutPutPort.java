package com.diegotorres.evaluaciondiegotorres.aplication.ouput.port;

import com.diegotorres.evaluaciondiegotorres.domain.Account;

import java.util.List;

public interface PersistenceAccountOutPutPort {
    Account getAccountById(Long id);

    List<Account> getAllAccount();

    Account createAccount(Account account);
    Account updateAccount(Account account,Long idAccount);
    void deleteAccount(long id);
}
