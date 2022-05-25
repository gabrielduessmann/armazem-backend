package com.armazem.armazenamentos;

import com.armazem.armazenamentos.dto.ArmazenamentoAdicionarDto;
import com.armazem.armazenamentos.dto.ArmazenamentoListarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ArmazenamentoController {

    @Autowired
    private ArmazenamentoService armazenamentoService;

    private final String ARMAZENAMENTOS_URL = "armazenamentos";

    @PostMapping(ARMAZENAMENTOS_URL+"/criar")
    public ResponseEntity<Void> adicionarAlocacao(@RequestBody ArmazenamentoAdicionarDto armazenamento) {
        armazenamentoService.adicionarArmazenamento(armazenamento);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(ARMAZENAMENTOS_URL+"/listar")
    public ResponseEntity<ArrayList<ArmazenamentoListarDto>> listarAlocacoes() {
        return ResponseEntity.ok(armazenamentoService.listarArmazenamentos());
    }

    @GetMapping(ARMAZENAMENTOS_URL+"/{armazenamentoId}/listar")
    public ResponseEntity<ArmazenamentoListarDto> listarAlocacoesPorId(@PathVariable UUID armazenamentoId) {
        return ResponseEntity.ok(armazenamentoService.listarArmazenamentosPorId(armazenamentoId));
    }

    @PostMapping(ARMAZENAMENTOS_URL+"/{armazenamentoId}/editar")
    public ResponseEntity<Void> editarAlocacao(@PathVariable UUID armazenamentoId, @RequestBody ArmazenamentoAdicionarDto armazenamento) {
        armazenamentoService.editarArmazenamento(armazenamentoId, armazenamento);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(ARMAZENAMENTOS_URL+"/{armazenamentoId}/remover")
    public ResponseEntity<Void> deletarAlocacao(@PathVariable UUID armazenamentoId) {
        armazenamentoService.deletarArmazenamento(armazenamentoId);
        return ResponseEntity.noContent().build();
    }
}
