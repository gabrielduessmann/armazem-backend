package com.armazem.armazenamentos.dto;

import lombok.Builder;

@Builder
public class ArmazenamentoListarDto {
    public String armazenamentoId;

    public String quantidade;

    public String nomegalpao;

    public String setorestoque;

    public String nomeproduto;

    public String descricao;
}
