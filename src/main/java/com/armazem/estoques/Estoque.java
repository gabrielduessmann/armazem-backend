package com.armazem.estoques;

import com.armazem.empresas.Empresa;
import com.armazem.galpoes.Galpao;
import com.armazem.produtos.Produto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Estoque {
    @Id
    @GeneratedValue
    private UUID id;

    private Integer quantidade;

    private Date ultimaatualizacao;

    @ManyToOne
    private Galpao galpao;

    @ManyToOne
    private Empresa empresa;

    @ManyToMany
    private Set<Produto> produtos;
}
