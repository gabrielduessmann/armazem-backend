package com.armazem.estoques;

import com.armazem.galpoes.Galpao;
import com.armazem.produtos.Produto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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

    @OneToOne
    private Galpao galpoes;

//    @ManyToMany
//    private Set<Produto> produtos;
}
