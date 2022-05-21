package com.armazem.galpoes.dto;

import com.armazem.estoques.dto.EstoqueCriarDto;

import java.util.List;
import java.util.UUID;

public class GalpaoCriarDto {
    public String nome;

    public String descricao;

    public UUID enderecoId;

    public List<EstoqueCriarDto> estoques;
}
