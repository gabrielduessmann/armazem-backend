package com.armazem.relatorios;

import com.armazem.alocacoes.dto.AlocacaoListarDto;
import com.armazem.relatorios.dto.RelatorioEstoquesAtivosListagemDto;
import com.armazem.relatorios.dto.RelatorioHistoricoEstoquesListagemDto;
import com.armazem.relatorios.dto.RelatorioProdutosArmazenadosListagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public ArrayList<RelatorioProdutosArmazenadosListagemDto> listarProdutosArmazenados(UUID empresaId) {
        ArrayList<Tuple> tuplas =  relatorioRepository.listarProdutosArmazenados(empresaId, LocalDate.now());
        return convertToRelatorioProdutosArmazenadosListagemDto(tuplas);
    }

    public ArrayList<RelatorioEstoquesAtivosListagemDto> listarEstoquesAtivos() {
        ArrayList<Tuple> tuplas = relatorioRepository.listarEstoquesAtivos(LocalDate.now());
        return convertToRelatorioEstoquesAtivosListagemDto(tuplas);
    }

    public ArrayList<RelatorioHistoricoEstoquesListagemDto> listarHistoricoEstoques(UUID empresaId, String dataInicialFiltro, String dataFinalFiltro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dataInicial = LocalDate.parse(dataInicialFiltro);
        LocalDate dataFinal = LocalDate.parse(dataFinalFiltro);
        System.out.println(dataFinal);
        ArrayList<Tuple> tuplas = relatorioRepository.listarHistoricoEstoques(empresaId, dataInicial, dataFinal);
        return convertToRelatorioHistoricoEstoquesListagemDto(tuplas);
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

    private ArrayList<RelatorioEstoquesAtivosListagemDto> convertToRelatorioEstoquesAtivosListagemDto(ArrayList<Tuple> tuplas) {
        ArrayList<RelatorioEstoquesAtivosListagemDto> relatorioLista = new ArrayList<>();
        tuplas.forEach(tupla -> {
            relatorioLista.add(
                    RelatorioEstoquesAtivosListagemDto.builder()
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .datafinalalocacao(obterValorTupla(tupla.get("datafinalalocacao")))
                            .build()
            );
        });
        return relatorioLista;
    }

    private ArrayList<RelatorioHistoricoEstoquesListagemDto> convertToRelatorioHistoricoEstoquesListagemDto(ArrayList<Tuple> tuplas) {
        ArrayList<RelatorioHistoricoEstoquesListagemDto> relatorioLista = new ArrayList<>();
        tuplas.forEach(tupla -> {
            relatorioLista.add(
                    RelatorioHistoricoEstoquesListagemDto.builder()
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .build()
            );
        });
        return relatorioLista;
    }


    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }
}

