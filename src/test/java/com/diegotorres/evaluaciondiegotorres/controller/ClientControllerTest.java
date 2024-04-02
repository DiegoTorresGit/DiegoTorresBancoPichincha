package com.diegotorres.evaluaciondiegotorres.controller;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.AccountInputPort;
import com.diegotorres.evaluaciondiegotorres.aplication.service.ServiceClient;
import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.domain.Client;
import com.diegotorres.evaluaciondiegotorres.domain.ClientPerson;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.AccountDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ClientDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.ClientPersonDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl.AccountController;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl.ClientController;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.AccountMapper;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.ClientMapper;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.ClientPersonMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;


public class ClientControllerTest {
    @InjectMocks
    private ClientController clientController;
    @Mock
    private ServiceClient serviceClient;
    @Mock
    private ClientMapper clientMapper;
    @Mock
    private ClientPersonMapper clientPersonMapper;
    @Mock
    private AccountInputPort accountInputPort;
    @Mock
    private AccountMapper accountMapper;
    @InjectMocks
    private AccountController accountController;

    public ClientControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateAccount() throws IOException {
        Long idAccount = 1L;
        AccountDto accountDto = new AccountDto();
        Account account = new Account();

        Mockito.when(accountMapper.ToDomain(accountDto)).thenReturn(account);
        Mockito.when(accountInputPort.updateAccount(account, idAccount)).thenReturn(account);
        Mockito.when(accountMapper.ToAccount(account)).thenReturn(accountDto);

        ResponseEntity<AccountDto> responseEntity = accountController.updateAccount(accountDto, idAccount);

        Mockito.verify(accountMapper, times(1)).ToDomain(accountDto);
        Mockito.verify(accountInputPort, times(1)).updateAccount(account, idAccount);
        Mockito.verify(accountMapper, times(1)).ToAccount(account);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    public void testClientConstructorAndGetters() {
        Long id = 1L;
        Date date = new Date();
        Boolean state = true;

        Client client = new Client();
        client.setDate(date);
        client.setId(id);
        client.setState(state);

        assertEquals(id, client.getId());
        assertEquals(date, client.getDate());
        assertEquals(state, client.getState());
    }
    @Test
    public void testCreateClient() {
        String idPerson = "123";
        ClientDto clientDto = new ClientDto();
        ClientPerson auxClient = new ClientPerson();
        ClientPersonDto auxClientDto = new ClientPersonDto();

        Mockito.when(clientMapper.toEntityDomain(clientDto)).thenReturn(new Client());
        Mockito.when(serviceClient.createClient(any(Client.class), anyLong())).thenReturn(auxClient);
        Mockito.when(clientPersonMapper.toDtoAux(auxClient)).thenReturn(auxClientDto);

        ResponseEntity<ClientPersonDto> responseEntity = clientController.createClient(clientDto, idPerson);

        Mockito.verify(clientMapper, times(1)).toEntityDomain(clientDto);
        Mockito.verify(serviceClient, times(1)).createClient(any(Client.class), anyLong());
        Mockito.verify(clientPersonMapper, times(1)).toDtoAux(auxClient);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
