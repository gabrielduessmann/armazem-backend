package com.armazem.alocacoes;

import com.armazem.alocacoes.dto.AlocacaoAdicionarDto;
import com.armazem.alocacoes.dto.AlocacaoListarDto;
import com.armazem.empresas.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class AlocacaoController {

    @Autowired
    private AlocacaoService alocacaoService;

    private final String ALOCACOES_URL = "alocacoes";

    @PostMapping(ALOCACOES_URL+"/adicionar")
    public ResponseEntity<Void> adicionarAlocacao(@RequestBody AlocacaoAdicionarDto alocacao) {
        alocacaoService.adicionarAlocacao(alocacao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(ALOCACOES_URL+"/listar")
    public ResponseEntity<ArrayList<AlocacaoListarDto>> listarAlocacoes() {
        return ResponseEntity.ok(alocacaoService.listarAlocacoes());
    }

    @GetMapping(ALOCACOES_URL+"/{id}/listar")
    public ResponseEntity<ArrayList<AlocacaoListarDto>> listarAlocacoesPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(alocacaoService.listarAlocacoesPorId(id));
    }

    @PostMapping(ALOCACOES_URL+"/{id}/editar")
    public ResponseEntity<Void> editarAlocacao(@PathVariable UUID id, @RequestBody AlocacaoAdicionarDto alocacao) {
        alocacaoService.editarAlocacao(id, alocacao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(ALOCACOES_URL+"{id}/remover")
    public ResponseEntity<Void> deletarAlocacao(@PathVariable UUID id) {
        alocacaoService.deletarAlocacao(id);
        return ResponseEntity.noContent().build();
    }
}
