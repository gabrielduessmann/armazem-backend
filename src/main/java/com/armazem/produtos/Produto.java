package com.armazem.produtos;

import com.armazem.estoques.Estoque;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String descricao;

    private Double precocompra;

//    @OneToMany(mappedBy = "produto")
//    private Set<Estoque> estoques;
}
