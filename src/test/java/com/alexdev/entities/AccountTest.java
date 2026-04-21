package com.alexdev.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    Account account;
    Account accountTwo;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setId(1L);
        account.setOwner("Account");
        account.setBalance(BigDecimal.valueOf(500));

        accountTwo = new Account();
        accountTwo.setId(2L);
        accountTwo.setOwner("AccountTwo");
        accountTwo.setBalance(BigDecimal.valueOf(500));
    }

    /*
    Arrange → preparar dados
    Act     → executar a ação
    Assert  → verificar resultado
     */

    @Test
    void shouldDepositMoney() {

        BigDecimal depositValue = BigDecimal.valueOf(200);

        account.deposit(depositValue); // Depositando R$200 em account

        assertEquals(BigDecimal.valueOf(700), account.getBalance()); // Tinha R$500, +R$200, tem que subir para R$700
    }

    @Test
    void shouldWithdrawMoney() {

        BigDecimal withdrawValue = BigDecimal.valueOf(200);

        account.withdraw(withdrawValue); // Sacando R$200 da Conta

        assertEquals(BigDecimal.valueOf(300), account.getBalance()); // Tinha R$500, -R$200, tem que sobrar R$300
    }

    @Test
    void shouldTransferMoney() {

        account.transfer(accountTwo, BigDecimal.valueOf(500)); // Transferindo R$500 de account para accountTwo

        assertEquals(BigDecimal.ZERO, account.getBalance()); // Tinha R$500 em account -R$500 tem que sobrar R$0

        assertEquals(BigDecimal.valueOf(1000), accountTwo.getBalance()); // Tinha R$500 em accountTwo +R$500, tem que subir para R$1000
    }
}