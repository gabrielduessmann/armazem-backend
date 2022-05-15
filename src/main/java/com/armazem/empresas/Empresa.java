package com.armazem.empresas;

import com.armazem.enderecos.Endereco;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue
    private UUID id;

    // ver se aceitar BigInterger como tipo para coluna
    private String cnpj;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Endereco endereco;
}
