package com.diegotorres.evaluaciondiegotorres.aplication.input.port;

import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;

public interface ClientInputPort {
    Client getClientById(Long id);
    Client updateClient(Client client, Long idClient);
    void deleteClient(long id);
    ClientPerson createClient(Client client, Long idPerson);
}
