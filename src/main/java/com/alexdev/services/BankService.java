package com.alexdev.services;

import com.alexdev.entities.Account;
import com.alexdev.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private final AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Account deposit(Long id, BigDecimal value) {
        Account account = findAccountById(id);

        account.deposit(value);

        return accountRepository.save(account);
    }

    public Account withdraw(Long id, BigDecimal value) {
        Account account = findAccountById(id);

        account.withdraw(value);

        return accountRepository.save(account);
    }

    public void transfer(Long originId, Long destinationId, BigDecimal value) {
        Account origin = findAccountById(originId);
        Account destination = findAccountById(destinationId);

        origin.transfer(destination, value);

        accountRepository.save(origin);
        accountRepository.save(destination);
    }

    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found!"));
    }
}
