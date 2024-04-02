package com.diegotorres.evaluaciondiegotorres.infraestructure.output.adapter;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.AccountInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceTransactionOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.AccountDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.AccountMapper;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.TransactionRepository;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TransacctionEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper.TransacctionPersistenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@PersistenceContext
public class PersistenceTransactionOutPutPortImpl implements PersistenceTransactionOutPutPort {

    private final TransacctionPersistenceMapper transacctionPersistenceMapper;
    private final TransactionRepository transactionRepository;

    private final AccountInputPort accountInputPort;
    private final AccountMapper accountMapper;

    private EntityManager entityManager;
    private JdbcTemplate jdbcTemplate;

    @Override
    public Trasaction updateTrnsaction(Trasaction client, Long idClient) {
        return null;
    }

    @Override
    public void deleteTrnsaction(long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Trasaction createTrnsaction(Trasaction trasaction) {
        TransacctionEntity te = transacctionPersistenceMapper.toEntity(trasaction);
        return transacctionPersistenceMapper.toDomain(transactionRepository.save(te));
    }
}
