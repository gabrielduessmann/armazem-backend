package com.armazem.empresas.dto;

import lombok.Builder;

@Builder
public class EmpresaCriarDto {
    public String empresaId;

    public String cnpj;

    public String nome;
}
