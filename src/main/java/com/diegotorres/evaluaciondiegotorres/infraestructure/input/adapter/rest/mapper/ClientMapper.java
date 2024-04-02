package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface ClientMapper {
    ClientDto toDto(Client client);
    Client toEntityDomain(ClientDto clientDto);

}
