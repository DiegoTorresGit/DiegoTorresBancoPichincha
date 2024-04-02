package com.diegotorres.evaluaciondiegotorres.aplication.ouput.port;

import com.diegotorres.evaluaciondiegotorres.domain.TypeAccount;

public interface PersistenceTypeAccountOutPutPort {

    TypeAccount getTypeAccounById (Integer id);
}
