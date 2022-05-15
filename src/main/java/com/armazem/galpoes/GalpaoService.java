package com.armazem.galpoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GalpaoService {
    @Autowired
    private GalpaoRepository galpaoRepository;

    public void criarGalpao(Galpao galpao) {
        System.out.println(galpao);
        galpaoRepository.criarGalpao(UUID.randomUUID(), galpao.getCodigo(), galpao.getCapacidade(), galpao.getEndereco().getId());
    }

    public ArrayList<Galpao> listarGalpoes() {
        return galpaoRepository.listarGalpoes();
    }

    public void editarGalpao(Galpao galpao) {
        galpaoRepository.editarGalpao(UUID.randomUUID(), galpao.getCodigo(), galpao.getCapacidade(), galpao.getEndereco().getId());
    }


    public void deletarGalpao(UUID id) {
        galpaoRepository.deletarGalpao(id);
    }
}
