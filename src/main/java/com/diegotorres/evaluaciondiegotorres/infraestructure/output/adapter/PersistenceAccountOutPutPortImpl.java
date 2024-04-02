package com.diegotorres.evaluaciondiegotorres.infraestructure.output.adapter;

import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceAccountOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.AccountRepository;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.AccountEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper.AccountPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PersistenceAccountOutPutPortImpl implements PersistenceAccountOutPutPort {

    private final AccountRepository accountRepository;
    private final AccountPersistenceMapper accountPersistenceMapper;

    @Override
    public Account getAccountById(Long id) {
        AccountEntity accountEntity= accountRepository.findById(id).get();
        return accountPersistenceMapper.toAccount(accountEntity);
    }

    public List<Account> getAllAccount() {
        Iterable<AccountEntity> accountEntity = accountRepository.findAll();
        List<AccountEntity> lista = new ArrayList<>();
        for (AccountEntity account : accountEntity) {
            lista.add(account);
        }
        return accountPersistenceMapper.ToAccounList(lista);
    }

    @Override
    public Account createAccount(Account account) {

       return accountPersistenceMapper.toAccount(accountRepository.save(accountPersistenceMapper.toEntity(account)));
    }

    @Override
    public Account updateAccount(Account account, Long idAccount) {

        AccountEntity accountEntity = accountRepository.findById(idAccount).get();
        accountEntity.setInitial_balance(account.getInitial_balance());
        AccountEntity accountEntity1 = accountRepository.save(accountEntity);
        return accountPersistenceMapper.toAccount(accountEntity1);
    }

    @Override
    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }
}
