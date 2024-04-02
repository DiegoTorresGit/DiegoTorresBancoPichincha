package com.diegotorres.evaluaciondiegotorres.aplication.service;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.ClientInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersistencePersonOutPutPort;
import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersitenceClienteOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;
import com.diegotorres.evaluaciondiegotorres.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ServiceClient implements ClientInputPort {

    private final PersitenceClienteOutPutPort persitenceClienteOutPutPort;
    private final PersistencePersonOutPutPort persistencePersonOutPutPort;

    @Override
    public Client getClientById(Long id) {
        return persitenceClienteOutPutPort.getClientById(id);
    }

    @Override
    public Client updateClient(Client client, Long idClient) {

        return persitenceClienteOutPutPort.updateClient(client,idClient);
    }

    @Override
    public void deleteClient(long id) {
        persitenceClienteOutPutPort.deleteClient(id);
    }

    @Override
    public ClientPerson createClient(Client client, Long idPerson) {
        Person person = persistencePersonOutPutPort.getPersonById(idPerson);
        ClientPerson clientPerson = ClientPerson.builder().date(client.getDate()).state(client.getState()).person(person).build();
        return persitenceClienteOutPutPort.createClient(clientPerson);
    }
}
