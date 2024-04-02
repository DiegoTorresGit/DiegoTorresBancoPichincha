package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.ClientInputPort;
import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ClientDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ClientPersonDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.ClientMapper;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.ClientPersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientInputPort serviceClient;
    private final ClientMapper clientMapper;
    private final ClientPersonMapper clientPersonMapper;

    @GetMapping("/clientes")
    public ResponseEntity<ClientDto> getClientById(@RequestParam("id") Long idClient) {

        Client client = serviceClient.getClientById(idClient);
        ClientDto clientDto = clientMapper.toDto(client);
        return ResponseEntity.ok(clientDto);
    }

    @PostMapping("/clientes/{id}")
    public ResponseEntity<ClientPersonDto> createClient(@RequestBody ClientDto client, @PathVariable("id") String idPerson) {
        ClientPerson auxClient = serviceClient.createClient(clientMapper.toEntityDomain(client), Long.parseLong(idPerson));
        return ResponseEntity.ok(clientPersonMapper.toDtoAux(auxClient));
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto client, @PathVariable("id") Long idClient) {
        Client _client = serviceClient.updateClient(clientMapper.toEntityDomain(client),idClient);
        ClientDto clientDto = clientMapper.toDto(_client);
        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping("/clientes")
    public void deleteClient(@RequestParam("id") String idClient) {
        serviceClient.deleteClient(Long.parseLong(idClient));
        ResponseEntity.ok();
    }
}
