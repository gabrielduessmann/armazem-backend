package com.armazem.relatorios;

import com.armazem.relatorios.dto.RelatorioEstoquesAtivosListagemDto;
import com.armazem.relatorios.dto.RelatorioHistoricoEstoquesListagemDto;
import com.armazem.relatorios.dto.RelatorioProdutosArmazenadosListagemDto;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    private final String RELATORIOS_URL = "relatorios";

    @GetMapping(RELATORIOS_URL+"/produtosArmazenados/{empresaId}/listar")
    public ResponseEntity<ArrayList<RelatorioProdutosArmazenadosListagemDto>> listarProdutosArmazenados(@PathVariable UUID empresaId) {
        if (empresaId == null) ResponseEntity.internalServerError();
        return ResponseEntity.ok(relatorioService.listarProdutosArmazenados(empresaId));
    }

    @GetMapping(RELATORIOS_URL+"/estoquesAtivos/listar")
    public ResponseEntity<ArrayList<RelatorioEstoquesAtivosListagemDto>> listarEstoquesAtivos() {
        return ResponseEntity.ok(relatorioService.listarEstoquesAtivos());
    }

    @GetMapping(RELATORIOS_URL+"/historicoEstoques/{empresaId}/listar")
    public ResponseEntity<ArrayList<RelatorioHistoricoEstoquesListagemDto>> listarHistoricoEstoques(@PathVariable UUID empresaId, @RequestParam(value = "dataInicial") String dataInicial, @RequestParam(value = "dataFinal") String dataFinal) {
        if (dataInicial == null || dataInicial.equals("") || dataFinal == null || dataFinal.equals("")) ResponseEntity.internalServerError();
        return ResponseEntity.ok(relatorioService.listarHistoricoEstoques(empresaId, dataInicial, dataFinal));
    }
}
