package com.armazem.enderecos;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private UUID id;

    private Integer cep;

    private String complemento;
}