package com.armazem.galpoes;

import com.armazem.galpoes.dto.GalpaoCriarDto;
import com.armazem.galpoes.dto.GalpaoListarDto;
import com.armazem.relatorios.dto.RelatorioProdutosArmazenadosListagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GalpaoService {
    @Autowired
    private GalpaoRepository galpaoRepository;

    public void criarGalpao(Galpao galpao) {
        galpaoRepository.criarGalpao(UUID.randomUUID(), galpao.getNome(), galpao.getDescricao(), galpao.getCidade(), galpao.getBairro(), galpao.getRua(), galpao.getNumero(), galpao.getComplemento());
    }

    public ArrayList<Galpao> listarGalpoes() {
        return galpaoRepository.listarGalpoes();
    }

    public ArrayList<Galpao> listarGalpoesPorId() {
        return galpaoRepository.listarGalpoes();
    }

    public void editarGalpao(UUID id, Galpao galpao) {
        galpaoRepository.editarGalpao(id, galpao.getNome(), galpao.getDescricao(), galpao.getCidade(), galpao.getBairro(), galpao.getRua(), galpao.getNumero(), galpao.getComplemento());
    }


    public void deletarGalpao(UUID id) {
        galpaoRepository.deletarGalpao(id);
    }

    private ArrayList<GalpaoListarDto> convertToGalpaoListarDtoListarTodos(ArrayList<Tuple> tuplas) {
        ArrayList<GalpaoListarDto> galpoes = new ArrayList<>();
        tuplas.forEach(tupla -> {
            galpoes.add(
                    GalpaoListarDto.builder()
                            .id(obterValorTupla(tupla.get("id")))
                            .nome(obterValorTupla(tupla.get("nome")))
                            .descricao(obterValorTupla(tupla.get("descricao")))
                            .build()
            );
        });
        return galpoes;
    }

    private ArrayList<GalpaoListarDto> convertToGalpaoListarDtoListarPorId(ArrayList<Tuple> tuplas) {
        ArrayList<GalpaoListarDto> galpoes = new ArrayList<>();
        tuplas.forEach(tupla -> {
            galpoes.add(
                    GalpaoListarDto.builder()
                            .id(obterValorTupla(tupla.get("id")))
                            .nome(obterValorTupla(tupla.get("nome")))
                            .descricao(obterValorTupla(tupla.get("descricao")))
                            .build()
            );
        });
        return galpoes;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }
}
