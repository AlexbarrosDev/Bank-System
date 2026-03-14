package com.alexdev.entities;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction implements Serializable {

    private Long id;
    private TransactionalType type;
    private BigDecimal amount;
    private Instant date;
}

