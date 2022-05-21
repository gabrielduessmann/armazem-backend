package com.armazem.galpoes;

import com.armazem.galpoes.dto.GalpaoCriarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GalpaoService {
    @Autowired
    private GalpaoRepository galpaoRepository;

    public void criarGalpao(GalpaoCriarDto galpao) {
        galpaoRepository.criarGalpao(UUID.randomUUID(), galpao.nome, galpao.descricao, galpao.enderecoId);
    }

    public ArrayList<Galpao> listarGalpoes() {
        return galpaoRepository.listarGalpoes();
    }

    public void editarGalpao(UUID id, GalpaoCriarDto galpao) {
        galpaoRepository.editarGalpao(id, galpao.nome, galpao.descricao, galpao.enderecoId);
    }


    public void deletarGalpao(UUID id) {
        galpaoRepository.deletarGalpao(id);
    }
}
