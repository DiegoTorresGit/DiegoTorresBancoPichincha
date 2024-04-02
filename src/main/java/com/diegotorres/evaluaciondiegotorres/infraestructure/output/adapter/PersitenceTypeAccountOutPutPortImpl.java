package com.diegotorres.evaluaciondiegotorres.infraestructure.output.adapter;

import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistenceTypeAccountOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.TypeAccount;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.TypeAccountRepository;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.AccountEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TypeAccountEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper.TypeAccountPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PersitenceTypeAccountOutPutPortImpl implements PersistenceTypeAccountOutPutPort {

  private final TypeAccountRepository typeAccountRepository;
  private final TypeAccountPersistenceMapper typeAccountPersistenceMapper;
    @Override
    public TypeAccount getTypeAccounById(Integer id) {
        Long idl= id.longValue();
        TypeAccountEntity typeAccountEntity = typeAccountRepository.findById(idl).get();
        return typeAccountPersistenceMapper.toAccount(typeAccountEntity);
    }
}
