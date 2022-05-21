package com.armazem.armazenamentos;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class ArmazenamentoPKs implements Serializable {
    private UUID estoque;

    private UUID produto;
}
