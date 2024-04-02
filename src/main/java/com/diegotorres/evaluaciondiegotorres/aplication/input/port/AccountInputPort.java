package com.diegotorres.evaluaciondiegotorres.aplication.input.port;

import com.diegotorres.evaluaciondiegotorres.domain.Account;

import java.util.List;

public interface AccountInputPort {
    Account getAccountById(Long id);

    List<Account> getAllAccount();
    Account updateAccount(Account account, Long idAccount);
    void deleteAcount(long id);
    Account  createAccount(Account account, Integer type, Long idClient);
}
