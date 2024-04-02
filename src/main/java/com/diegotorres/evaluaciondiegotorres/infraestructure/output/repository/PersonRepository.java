package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository;

import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
}
