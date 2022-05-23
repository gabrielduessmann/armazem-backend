package com.armazem.alocacoes.dto;

import java.time.LocalDate;
import java.util.UUID;

public class AlocacaoAdicionarDto {

    public UUID alocacaoId;

    public UUID estoqueId;

    public UUID empresaId;

    public LocalDate dataInicial;

    public LocalDate dataFinal;
}
