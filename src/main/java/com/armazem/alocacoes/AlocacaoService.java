package com.armazem.alocacoes;

import com.armazem.alocacoes.dto.AlocacaoAdicionarDto;
import com.armazem.alocacoes.dto.AlocacaoListarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlocacaoService {

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    public void adicionarAlocacao(AlocacaoAdicionarDto alocacao) {
        alocacaoRepository.adicionarAlocacao(UUID.randomUUID(), alocacao.estoqueId, alocacao.empresaId, alocacao.datainicial, alocacao.datafinal);
    }

    public ArrayList<AlocacaoListarDto> listarAlocacoes() {
        ArrayList<Tuple> tuplas = alocacaoRepository.listarAlocacoes();
        return convertToAlocacaoListarDto(tuplas);
    }

    public AlocacaoListarDto listarAlocacoesPorId(UUID id) {
        Tuple tupla = alocacaoRepository.listarAlocacoesPorId(id);
        return convertToAlocacaoListarDto(List.of(tupla)).size() == 1 ?
                convertToAlocacaoListarDto(List.of(tupla)).get(0) :
                null;
    }

    public void editarAlocacao(UUID id, AlocacaoAdicionarDto alocacao) {
        alocacaoRepository.editarAlocacao(id, alocacao.estoqueId, alocacao.empresaId, alocacao.datainicial, alocacao.datafinal);
    }

    public void deletarAlocacao(UUID id) {
        alocacaoRepository.deletarAlocacao(id);
    }


    private ArrayList<AlocacaoListarDto> convertToAlocacaoListarDto(List<Tuple> tuplas) {
        ArrayList<AlocacaoListarDto> alocacoesDto = new ArrayList<>();
        tuplas.forEach(tupla -> {
            alocacoesDto.add(
                    AlocacaoListarDto.builder()
                            .alocacaoid(obterValorTupla(tupla.get("alocacaoid")))
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .nomeempresa(obterValorTupla(tupla.get("nomeempresa")))
                            .datainicial(obterValorTupla(tupla.get("datainicial")))
                            .datafinal(obterValorTupla(tupla.get("datafinal")))
                            .build()
            );
        });
        return alocacoesDto;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }

}
