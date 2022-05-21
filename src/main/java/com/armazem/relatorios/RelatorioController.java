package com.armazem.relatorios;

import com.armazem.relatorios.dto.RelatorioProdutosArmazenadosListagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    private final String RELATORIOS_URL = "relatorios";

    @GetMapping(RELATORIOS_URL+"/produtosArmazenados/{empresaId}/listar")
    public ResponseEntity<ArrayList<RelatorioProdutosArmazenadosListagemDto>> listarProdutosArmazenados(@PathVariable UUID empresaId) {
        return ResponseEntity.ok(relatorioService.listarProdutosArmazenados(empresaId));
    }
}
