package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.TransactionDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TransacctionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TransactionMapper {

    TransactionDto toDto (TransacctionEntity transacctionEntity);
    Trasaction ToEntity (TransactionDto transactionDto);

}
