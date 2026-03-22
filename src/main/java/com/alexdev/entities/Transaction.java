package com.alexdev.entities;

import com.alexdev.entities.enums.TransactionalType;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction implements Serializable {

    private Long id;
    private TransactionalType type;
    private BigDecimal amount;
    private Instant date;

    public Transaction(Long id, TransactionalType type, BigDecimal amount, Instant date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }
}

