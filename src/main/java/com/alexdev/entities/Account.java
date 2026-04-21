package com.alexdev.entities;

import com.alexdev.exceptions.InsufficientBalanceException;
import com.alexdev.exceptions.InvalidAmountException;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Account implements Serializable {

    private Long id;
    private String owner;
    private BigDecimal balance = BigDecimal.ZERO;

    @Setter(AccessLevel.NONE)
    private List<Transaction> transactions = new ArrayList<>();

    public Account(Long id, String owner, BigDecimal balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
         throw new InvalidAmountException("Invalid value");
        }
        balance = balance.add(value);
    }

    public void withdraw(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Invalid value!");
        }

        if (balance.compareTo(value) < 0) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance = balance.subtract(value);
    }

    public void transfer(Account account, BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Invalid value!");
        }

        if (account.getBalance().compareTo(value) < 0) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        withdraw(value);
        account.deposit(value);
    }
}
