package com.armazem.estoques.dto;

import lombok.Builder;

@Builder
public class EstoqueListarDto {
    public String estoqueId;

    public String nomegalpao;

    public String setor;

    public String capacidade;
}
