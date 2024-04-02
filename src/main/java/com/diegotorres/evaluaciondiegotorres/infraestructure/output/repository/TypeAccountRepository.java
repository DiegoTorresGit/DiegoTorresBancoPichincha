package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository;

import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.AccountEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TypeAccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeAccountRepository extends CrudRepository<TypeAccountEntity,Long> {
}
