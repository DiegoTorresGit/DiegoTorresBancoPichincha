package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AccountPersistenceMapper {
    Account toAccount(AccountEntity accountEntity);
    AccountEntity toEntity(Account account);
    List<Account> ToAccounList (List<AccountEntity> lsAccountEntity);


}
