package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClientPersonPersistenceMapper {

    ClientEntity toEntity(ClientPerson clientPerson);

    ClientPerson toDomain(ClientEntity clientPerson);

    ClientEntity toClient(Client client);

    Client toClient(ClientEntity clientEntity);
}
