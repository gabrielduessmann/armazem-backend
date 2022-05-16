package com.armazem.estoques_produtos;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class EstoqueProdutoPK implements Serializable {
    private UUID estoque;

    private UUID produto;
}
