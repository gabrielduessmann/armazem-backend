package com.armazem.produtos;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue
    private UUID produtoId;

    @Column(nullable = false)
    private String nome;

    private String descricao;


//    @OneToMany(mappedBy = "produto")
//    private Set<Estoque> estoques;
}
