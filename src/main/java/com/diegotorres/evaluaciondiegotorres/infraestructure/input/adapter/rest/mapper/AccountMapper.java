package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AccountMapper {
    AccountDto ToAccount(Account account);
    Account ToDomain (AccountDto accountDto);
    List<AccountDto> ToAccountDtoLs (List<Account> AccountList);

}
