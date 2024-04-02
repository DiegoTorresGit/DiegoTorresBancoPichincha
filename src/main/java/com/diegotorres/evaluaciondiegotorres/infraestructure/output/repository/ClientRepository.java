package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository;

import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity,Long> {

}
