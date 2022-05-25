package com.armazem.armazenamentos.dto;

import lombok.Builder;

@Builder
public class ArmazenamentoListarDto {
    public String estoqueid;

    public String produtoid;

    public String nomegalpao;

    public String setorestoque;

    public String nomeproduto;

    public String descricao;
}
