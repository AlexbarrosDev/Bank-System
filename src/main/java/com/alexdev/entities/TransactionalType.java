package com.alexdev.entities;

import java.io.Serializable;

public enum TransactionalType implements Serializable {

    DEPOSIT,
    WITHDRAW,
    TRANSFER;
}
