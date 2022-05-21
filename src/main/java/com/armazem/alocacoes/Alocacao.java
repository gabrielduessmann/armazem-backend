package com.armazem.alocacoes;

import com.armazem.empresas.Empresa;
import com.armazem.estoques.Estoque;
import com.armazem.produtos.Produto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Alocacao {
    @Id
    private UUID alocacaoId;

    @ManyToOne
    @JoinColumn(name="estoque_id", referencedColumnName = "estoqueId")
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name="empresa_id", referencedColumnName = "empresaId")
    private Empresa empresa;

    @Column(nullable = false)
    private LocalDate datainicial;

    private LocalDate datafinal;
}
