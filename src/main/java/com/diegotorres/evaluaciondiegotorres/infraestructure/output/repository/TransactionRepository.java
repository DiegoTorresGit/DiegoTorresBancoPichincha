package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository;

import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.TransacctionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransacctionEntity,Long> {

}
