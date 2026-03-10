package com.alexdev.entities;

import java.io.Serializable;
import java.math.BigDecimal;

    public class Account implements Serializable {

    private Long id;
    private String owner;
    private BigDecimal balance;

    public void deposit(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
         throw new IllegalArgumentException("Inválid number");
        }
        balance = balance.add(value);
    }

    public void withdraw(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Inválid number!");
        }
        if (balance.compareTo(value) < 0) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance = balance.subtract(value);
    }

    public void transfer(Account account, BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Inválid number!");
        }
        withdraw(value);
        account.deposit(value);
    }
}
