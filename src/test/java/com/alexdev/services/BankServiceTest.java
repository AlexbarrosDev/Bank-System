package com.alexdev.services;
import com.alexdev.entities.Account;
import com.alexdev.exceptions.InsufficientBalanceException;
import com.alexdev.exceptions.InvalidAmountException;
import com.alexdev.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @InjectMocks
    private BankService service;

    @Mock
    private AccountRepository repository;

    @Test
    void shouldCreateAccount() { // deveCriarConta()

        Account account = new Account(1L, "Alice", BigDecimal.valueOf(1000));

        when(repository.save(account)).thenReturn(account);

        Account result = service.createAccount(account);

        assertNotNull(result);
        assertEquals(account, result);

        verify(repository).save(account);
    }

    @Test
    void shouldDepositMoney() { // deveDeposiarDinheiro()

        Account account = new Account(1L, "Alex", BigDecimal.valueOf(500));

        when(repository.findById(1L)).thenReturn(Optional.of(account));

        when(repository.save(account)).thenReturn(account);

        service.deposit(1L, BigDecimal.valueOf(200));

        assertEquals(BigDecimal.valueOf(700), account.getBalance());

        verify(repository).save(account);
    }

    @Test
    void shouldWithdrawMoney() { // DeveRetirarDinheiro()

        Account account = new Account(2L, "Giovanna", BigDecimal.valueOf(500));

        when(repository.findById(2L)).thenReturn(Optional.of(account));

        when(repository.save(account)).thenReturn(account);

        service.withdraw(2L, BigDecimal.valueOf(300));

        assertEquals(BigDecimal.valueOf(200), account.getBalance());

        verify(repository).save(account);
    }

    @Test
    void shouldTransferMoney() { // deveTrasfirirDinheiro()

        Account origin = new Account(1L, "Origin", BigDecimal.valueOf(1000));
        Account destination = new Account(2L, "Destination", BigDecimal.valueOf(1000));

        when(repository.findById(1L)).thenReturn(Optional.of(origin));
        when(repository.findById(2L)).thenReturn(Optional.of(destination));

        service.transfer(origin.getId(), destination.getId(), BigDecimal.valueOf(500));

        assertEquals(BigDecimal.valueOf(500), origin.getBalance());
        assertEquals(BigDecimal.valueOf(1500), destination.getBalance());

        verify(repository).save(origin);
        verify(repository).save(destination);
    }

    @Test
    void shouldFindAccountById() { // deveEncontrarContaPorID()

        Account account = new Account(1L, "João", BigDecimal.valueOf(1000));

        when(repository.findById(1L)).thenReturn(Optional.of(account));

        Account result = service.findAccountById(1L);

        assertEquals(account, result);

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void shouldNotWithdrawWhenInsufficientBalance() { // NaoDeveSerSacadoQuandoSaldoForInsuficiente()

        Account account = new Account(1L, "Maria", BigDecimal.valueOf(0));

        when(repository.findById(1L)).thenReturn(Optional.of(account));

        assertThrows(InsufficientBalanceException.class, () -> service.withdraw(1L, BigDecimal.valueOf(200)));

        verify(repository, never()).save(any());
    }

    @Test
    void shouldThrowInvalidAmountExceptionWhenWithdrawAmountIsZero() { // deveLancarExcecaoDeValorInvalidoQuandoValorDeSaqueEZero()

        Account account = accountFactory(1L, BigDecimal.valueOf(1000));

        when(repository.findById(1L)).thenReturn(Optional.of(account));

        assertThrows(InvalidAmountException.class, () -> service.withdraw(1L, BigDecimal.valueOf(0)));

        verify(repository, never()).save(any());
    }

    @Test
    void shouldThrowInvalidAmountExceptionWhenDepositAmountIsInvalid() { // deveLancarExcecaoDeValorInvalidoQuandoValorDepositoEInvalido()

        Account account = accountFactory(1L, BigDecimal.valueOf(1000));

        when(repository.findById(1L)).thenReturn(Optional.of(account));

        assertThrows(InvalidAmountException.class, () -> service.deposit(1L, BigDecimal.valueOf(-1)));

        verify(repository, never()).save(any());
    }

    private Account accountFactory(Long id, BigDecimal value) {

        return new Account(id, "User", value);
    }
}