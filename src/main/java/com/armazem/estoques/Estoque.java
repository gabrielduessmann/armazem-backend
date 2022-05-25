package com.armazem.estoques;

import com.armazem.galpoes.Galpao;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Estoque {
    @Id
    @GeneratedValue
    private UUID estoqueId;

    private String setor;

    @Column(nullable = false)
    private Integer capacidade;

    @ManyToOne
    @JoinColumn(name = "galpao_id")
    private Galpao galpao;

}
