package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.TypeAccount;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.AccountEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TypeAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TypeAccountPersistenceMapper {
    TypeAccount toAccount (TypeAccountEntity accountEntity);
}
