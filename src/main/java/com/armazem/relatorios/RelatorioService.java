package com.armazem.relatorios;

import com.armazem.alocacoes.dto.AlocacaoListarDto;
import com.armazem.relatorios.dto.RelatorioProdutosArmazenadosListagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public ArrayList<RelatorioProdutosArmazenadosListagemDto> listarProdutosArmazenados(UUID empresaId) {
        ArrayList<Tuple> tuplas =  relatorioRepository.listarProdutosArmazenados(empresaId);
        return convertToRelatorioProdutosArmazenadosListagemDto(tuplas);
    }

    private ArrayList<RelatorioProdutosArmazenadosListagemDto> convertToRelatorioProdutosArmazenadosListagemDto(ArrayList<Tuple> tuplas) {
        ArrayList<RelatorioProdutosArmazenadosListagemDto> relatorioLista = new ArrayList<>();
        tuplas.forEach(tupla -> {
            relatorioLista.add(
                    RelatorioProdutosArmazenadosListagemDto.builder()
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .nomeproduto(obterValorTupla(tupla.get("nomeproduto")))
                            .quantidade(obterValorTupla(tupla.get("quantidade")))
                            .ultimaatualizacao(obterValorTupla(tupla.get("ultimaatualizacao")))
                            .build()
            );
        });
        return relatorioLista;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }
}

