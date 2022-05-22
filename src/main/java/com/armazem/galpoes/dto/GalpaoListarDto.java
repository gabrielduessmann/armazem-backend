package com.armazem.galpoes.dto;

import com.armazem.estoques.dto.EstoqueListarDto;
import lombok.Builder;

import java.util.ArrayList;

@Builder
public class GalpaoListarDto {
    public String id;

    public String nome;

    public String descricao;

    public String cidade;

    public String bairro;

    public String rua;

    public String numero;

    public String complemento;

    public ArrayList<EstoqueListarDto> estoques;
}
