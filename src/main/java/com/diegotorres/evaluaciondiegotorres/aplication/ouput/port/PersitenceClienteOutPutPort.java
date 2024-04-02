package com.diegotorres.evaluaciondiegotorres.aplication.ouput.port;

import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;

public interface PersitenceClienteOutPutPort {
    Client getClientById(Long id);
    ClientPerson createClient(ClientPerson client);
    Client updateClient(Client client,Long idClient);
    void deleteClient(long id);
}
