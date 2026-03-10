package com.alexdev.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

public class Transaction implements Serializable {

    private Long id;
    private TransactionalType type;
    private BigDecimal amount;
    private Instant date;
}

