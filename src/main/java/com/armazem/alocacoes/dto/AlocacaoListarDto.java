package com.armazem.alocacoes.dto;

import lombok.Builder;

@Builder
public class AlocacaoListarDto {
    public String alocacaoid;

    public String nomegalpao;

    public String setorestoque;

    public String estoqueid;

    public String nomeempresa;

    public String empresaid;

    public String datainicial;

    public String datafinal;
}
