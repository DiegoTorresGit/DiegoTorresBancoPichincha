package com.diegotorres.evaluaciondiegotorres.aplication.ouput.port;

import com.diegotorres.evaluaciondiegotorres.domain.Person;

public interface PersistencePersonOutPutPort {
    Person getPersonById(Long id);
}
