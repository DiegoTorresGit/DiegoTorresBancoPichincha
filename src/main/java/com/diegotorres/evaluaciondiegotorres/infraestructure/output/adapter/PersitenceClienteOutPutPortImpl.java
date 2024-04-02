package com.diegotorres.evaluaciondiegotorres.infraestructure.output.adapter;

import com.diegotorres.evaluaciondiegotorres.aplication.ouput.port.PersitenceClienteOutPutPort;
import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.ClientMapper;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.ClientRepository;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.entity.ClientEntity;
import com.diegotorres.evaluaciondiegotorres.infraestructure.output.repository.mapper.ClientPersonPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@RequiredArgsConstructor
@Repository
public class PersitenceClienteOutPutPortImpl implements PersitenceClienteOutPutPort {

    private final ClientPersonPersistenceMapper clientPersonPersistenceMapper;
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;


    @Override
    public Client getClientById(Long id) {
        ClientEntity OptionalClient = clientRepository.findById(id).get();
        Client client = clientPersonPersistenceMapper.toClient(OptionalClient);
        return client;
    }

    public ClientPerson createClient(ClientPerson clientPerson) {

        ClientPerson clientPersonAux = clientPersonPersistenceMapper.toDomain(clientRepository.save(clientPersonPersistenceMapper.toEntity(clientPerson)));
        return clientPersonAux;
    }

    public Client updateClient(Client client,Long idClient) {
        ClientEntity cliente = clientRepository.findById(idClient).get();
        Date fecha = new Date(client.getDate().getTime());
        cliente.setDate(fecha);
        cliente.setState(client.getState());
         ClientEntity clientEntity   = clientRepository.save(cliente);
        return clientPersonPersistenceMapper.toClient(clientEntity);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }

}
