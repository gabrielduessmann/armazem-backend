package com.armazem.relatorios.dto;

import lombok.Builder;

@Builder
public class RelatorioProdutosArmazenadosListagemDto {
    public String nomegalpao;

    public String setorestoque;

    public String nomeproduto;

    public String quantidade;

    public String ultimaatualizacao;
}
