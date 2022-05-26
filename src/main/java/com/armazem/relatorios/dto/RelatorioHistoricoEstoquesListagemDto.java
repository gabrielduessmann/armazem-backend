package com.armazem.relatorios.dto;

import lombok.Builder;

@Builder
public class RelatorioHistoricoEstoquesListagemDto {
    public String nomegalpao;

    public String setorestoque;

    public String datainicial;

    public String datafinal;
}
