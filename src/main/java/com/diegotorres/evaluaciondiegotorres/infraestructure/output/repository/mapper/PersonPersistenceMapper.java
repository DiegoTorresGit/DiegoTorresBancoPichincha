package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper;

import com.diegotorres.evaluaciondiegotorres.domain.Person;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PersonPersistenceMapper {
    PersonEntity toEntity(Person person);

    Person toDomain(PersonEntity personEntity);
}
