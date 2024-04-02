package com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository;

import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ReporteDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    @Query(value="select bp.name as Nombre,ba.number AS Cuenta, bt.type AS Tipo, ba.initial_balance AS Saldo, btr.date AS Fecha, btr.initial_balance as SaldoInicial, btr.value AS Movimiento,btr.available_balance AS Disponible " +
            "from PersonEntity bp " +
            "join ClientEntity bc on bp.id=bc.person.id " +
            "join AccountEntity ba ON ba.client.id = bc.id " +
            "join TypeAccountEntity bt ON bt.id = ba.typeAccount.id " +
            "join TransacctionEntity btr ON btr.account.id = ba.id " +
            "WHERE bc.id= 1 ORDER BY ba.number",nativeQuery = true)


    ReporteDto ReportMove();
}
