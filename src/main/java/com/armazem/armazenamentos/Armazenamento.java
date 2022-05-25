package com.armazem.armazenamentos;

import com.armazem.estoques.Estoque;
import com.armazem.produtos.Produto;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Armazenamento {
    @Id
    @GeneratedValue
    private UUID armazenamentoId;

    @ManyToOne
    @JoinColumn(name="estoque_id", referencedColumnName = "estoqueId")
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name="produto_id", referencedColumnName = "produtoId")
    private Produto produto;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
    private LocalDate ultimaatualizacao;
}
