package com.armazem.armazenamentos;

import com.armazem.alocacoes.dto.AlocacaoListarDto;
import com.armazem.armazenamentos.dto.ArmazenamentoAdicionarDto;
import com.armazem.armazenamentos.dto.ArmazenamentoListarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ArmazenamentoService {

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    public void adicionarArmazenamento(ArmazenamentoAdicionarDto armazenamento) {
        LocalDate dataAtual = LocalDate.now();
        UUID armazenamentoId = UUID.randomUUID();
        armazenamentoRepository.adicionarArmazenamento(armazenamentoId, armazenamento.estoqueId, armazenamento.produtoId, armazenamento.quantidade, dataAtual);
    }

    public ArrayList<ArmazenamentoListarDto> listarArmazenamentos() {
        ArrayList<Tuple> tuplas = armazenamentoRepository.listarArmazenamentos();
        return convertToArmazenamentoListarDto(tuplas);
    }

    public ArmazenamentoListarDto listarArmazenamentosPorId(UUID armazenamentoId) {
        Tuple tupla = armazenamentoRepository.listarArmazenamentosPorId(armazenamentoId);
        return convertToArmazenamentoListarDto(List.of(tupla)).size() == 1 ?
                convertToArmazenamentoListarDto(List.of(tupla)).get(0) :
                null;
    }

    public void editarArmazenamento(UUID armazenamentoId, ArmazenamentoAdicionarDto armazenamento) {
        LocalDate dataAtual = LocalDate.now();
        armazenamentoRepository.editarArmazenamento(armazenamentoId, armazenamento.estoqueId, armazenamento.produtoId, armazenamento.quantidade, dataAtual);
    }

    public void deletarArmazenamento(UUID armazenamentoId) {
        armazenamentoRepository.deletarArmazenamento(armazenamentoId);
    }

    private ArrayList<ArmazenamentoListarDto> convertToArmazenamentoListarDto(List<Tuple> tuplas) {
        ArrayList<ArmazenamentoListarDto> armazenamentosDto = new ArrayList<>();
        tuplas.forEach(tupla -> {
            armazenamentosDto.add(
                    ArmazenamentoListarDto.builder()
                            .armazenamentoId(obterValorTupla(tupla.get("armazenamentoId")))
                            .quantidade(obterValorTupla(tupla.get("quantidade")))
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .estoqueId(obterValorTupla(tupla.get("estoqueId")))
                            .nomeproduto(obterValorTupla(tupla.get("nomeproduto")))
                            .produtoId(obterValorTupla(tupla.get("produtoId")))
                            .descricao(obterValorTupla(tupla.get("descricao")))
                            .build()
            );
        });
        return armazenamentosDto;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }
}
