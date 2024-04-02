package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository;

import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity,Long> {
}
