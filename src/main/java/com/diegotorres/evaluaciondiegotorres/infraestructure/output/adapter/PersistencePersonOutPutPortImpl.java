package com.diegotorres.evaluaciondiegotorres.infraestructure.output.adapter;

import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistencePersonOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Person;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.PersonRepository;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.PersonEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper.PersonPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersistencePersonOutPutPortImpl implements PersistencePersonOutPutPort {

    private final PersonRepository personRepository;
    private final PersonPersistenceMapper personPersistenceMapper;
    @Override
    public Person getPersonById(Long id) {
        PersonEntity optionalPerson = personRepository.findById(id).get();

        Person person = personPersistenceMapper.toDomain(optionalPerson);

        return personPersistenceMapper.toDomain(optionalPerson);
    }
}
