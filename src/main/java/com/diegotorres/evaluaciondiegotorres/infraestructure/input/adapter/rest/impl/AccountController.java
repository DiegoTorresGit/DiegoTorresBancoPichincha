package com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.impl;

import com.diegotorres.evaluaciondiegotorres.aplication.input.port.AccountInputPort;
import com.diegotorres.evaluaciondiegotorres.domain.Account;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.AccountDto;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountInputPort accountInputPort;
    private final AccountMapper accountMapper;

    @GetMapping("/cuentas")
    public ResponseEntity<AccountDto> getAccountByID(@RequestParam("id") Long idAccount) {
        Account account = accountInputPort.getAccountById(idAccount);
        AccountDto accountDto = accountMapper.ToAccount(account);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/cuentas/All")
    public ResponseEntity< List<AccountDto>> getAllAccount() {
        List<Account> account = accountInputPort.getAllAccount();
        List<AccountDto> accountDto = accountMapper.ToAccountDtoLs(account);
        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/cuentas")
    public void deleteAccount(@RequestParam("id") Long idAccount) {
       accountInputPort.deleteAcount(idAccount);
       ResponseEntity.ok();
    }

    @PostMapping("/cuentas")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto,@RequestParam("type") Integer type,@RequestParam("client") Long idClient) {
        Account account = accountInputPort.createAccount(accountMapper.ToDomain(accountDto),type,idClient);
        return ResponseEntity.ok(accountMapper.ToAccount(account));
    }

    @PutMapping("/cuentas")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto,@RequestParam("idAccount") Long idAccount) {
        Account account = accountInputPort.updateAccount(accountMapper.ToDomain(accountDto),idAccount);
        return new ResponseEntity<>(accountMapper.ToAccount(account), HttpStatus.OK);
    }
}
