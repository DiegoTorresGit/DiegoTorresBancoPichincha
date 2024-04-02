package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TransacctionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TransacctionPersistenceMapper {
    TransacctionEntity toEntity (Trasaction trasaction);
    Trasaction toDomain(TransacctionEntity transacctionEntity);
}
