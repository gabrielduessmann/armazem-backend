package com.armazem.estoques;

import com.armazem.empresas.Empresa;
import com.armazem.galpoes.Galpao;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Estoque {
    @Id
    @GeneratedValue
    private UUID estoqueId;

    private String setor;

    @ManyToOne
    private Galpao galpao;

    @ManyToOne
    private Empresa empresa;

//    @OneToMany(mappedBy = "estoque")
//    private Set<Produto> produtos;
}
