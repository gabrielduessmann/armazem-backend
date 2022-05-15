package com.armazem.galpoes;

import com.armazem.enderecos.Endereco;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class Galpao {
    @Id
    @GeneratedValue
    private UUID id;

    private String codigo;

    private Integer capacidade;

    @OneToOne
    private Endereco endereco;
}