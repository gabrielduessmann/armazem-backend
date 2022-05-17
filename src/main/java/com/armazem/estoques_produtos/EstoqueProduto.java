package com.armazem.estoques_produtos;

import com.armazem.estoques.Estoque;
import com.armazem.produtos.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="estoque_produto")
@IdClass(EstoqueProdutoPK.class)
public class EstoqueProduto {
    @Id
    @ManyToOne
    @JoinColumn(name="estoque_id", referencedColumnName = "id")
    private Estoque estoque;

    @Id
    @ManyToOne
    @JoinColumn(name="produto_id", referencedColumnName = "id")
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDate ultimaatualizacao;
}
