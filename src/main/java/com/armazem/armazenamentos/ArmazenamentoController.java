package com.armazem.armazenamentos;

import com.armazem.armazenamentos.dto.ArmazenamentoAdicionarDto;
import com.armazem.armazenamentos.dto.ArmazenamentoListarDto;
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
public class ArmazenamentoController {

    @Autowired
    private ArmazenamentoService armazenamentoService;

    private final String ARMAZENAMENTOS_URL = "armazenamentos";

    @PostMapping(ARMAZENAMENTOS_URL+"/adicionar")
    public ResponseEntity<Void> adicionarAlocacao(@RequestBody ArmazenamentoAdicionarDto armazenamento) {
        armazenamentoService.adicionarArmazenamento(armazenamento);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(ARMAZENAMENTOS_URL+"/listar")
    public ResponseEntity<ArrayList<ArmazenamentoListarDto>> listarAlocacoes() {
        return ResponseEntity.ok(armazenamentoService.listarEstoques());
    }

    @GetMapping(ARMAZENAMENTOS_URL+"/{estoqueId}/{produtoId}/listar")
    public ResponseEntity<ArrayList<ArmazenamentoListarDto>> listarAlocacoesPorId(@PathVariable UUID estoqueId, @PathVariable UUID produtoId) {
        return ResponseEntity.ok(armazenamentoService.listarEstoquesPorId(estoqueId, produtoId));
    }

    @PostMapping(ARMAZENAMENTOS_URL+"/{estoqueId}/{produtoId}/editar")
    public ResponseEntity<Void> editarAlocacao(@PathVariable UUID estoqueId, @PathVariable UUID produtoId, @RequestBody ArmazenamentoAdicionarDto armazenamento) {
        armazenamentoService.editarArmazenamento(estoqueId, produtoId, armazenamento);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(ARMAZENAMENTOS_URL+"/{estoqueId}/{produtoId}/remover")
    public ResponseEntity<Void> deletarAlocacao(@PathVariable UUID estoqueId, @PathVariable UUID produtoId) {
        armazenamentoService.deletarArmazenamento(estoqueId, produtoId);
        return ResponseEntity.noContent().build();
    }
}
